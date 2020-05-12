package io.andersclark.db;

import io.andersclark.models.Booking;
import io.andersclark.models.Customer;
import io.andersclark.models.Room;
import io.andersclark.models.Search;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

public class DB {
    private static DB INSTANCE = null;
    private static Connection conn;

    private DB(){
        connect();
    }

    public static DB getInstance () {
        if(INSTANCE == null){
            INSTANCE = new DB();
        }
        return INSTANCE;
    }

    public void connect(){
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/holidaymaker", "root", "root");
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void getAllCustomers(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM customers");
            while(res.next()){
               System.out.println("CUSTOMER: " + res.getString("firstname") + " " + res.getString("lastname"));
            }

        } catch(Exception e){e.printStackTrace();}
    }
    
    public void saveCustomer(Customer customer){
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO customers (firstname, lastname, email, phone) VALUES (?, ?, ?, ?)");
            stmt.setString(1, customer.getFirstname());
            stmt.setString(2, customer.getLastname());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.executeUpdate();
        } catch(Exception e){e.printStackTrace();}
    }

    public ArrayList<Room> searchRooms(Search search){
        ArrayList<Room> availableRooms = new ArrayList<>();
        try{
            String query = "SELECT * FROM rooms INNER JOIN locations on locations.id=rooms.location WHERE";
            query = query.concat(search.isDaycare() ? " daycare=1" : " daycare=0");
            query = query.concat(search.isPool() ? " AND pool=1" : " AND pool=0");
            query = query.concat(search.isEvening_entertainment() ? " AND evening_entertainment=1" : " AND evening_entertainment=0");
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(query);
            while(results.next()) {
                availableRooms.add(new Room(
                                results.getInt("id"),
                                results.getInt("location"),
                                results.getInt("beds"),
                                results.getInt("price")
                                ));
            }
            availableRooms.
        } catch (Exception e){
            e.printStackTrace();
        }
        return availableRooms;
    }
    public String bookRoom(LocalDate startDate, LocalDate endDate, int roomId, int customerId){
      try {
          Statement selectStmt = conn.createStatement();
          ResultSet matches = selectStmt.executeQuery("SELECT * FROM bookings WHERE start_date=" + Date.valueOf(startDate));
          if(matches.next()) {
              return "ERROR: Room is already booked this date";
          };
          selectStmt = conn.createStatement();
          matches = selectStmt.executeQuery("SELECT * FROM bookings WHERE end_date=" + Date.valueOf(endDate));
          if(matches.next()) {
              return "ERROR: Room is already booked this date";
          };
          PreparedStatement stmt = conn.prepareStatement("INSERT INTO bookings (start_date, end_date, registration_Date, room, customer) VALUES (?, ?, ?, ?, ?)");
          stmt.setDate(1, Date.valueOf(startDate));
          stmt.setDate(2, Date.valueOf(endDate));
          stmt.setDate(3, new Date(Instant.now().toEpochMilli()));
          stmt.setInt(4, roomId);
          stmt.setInt(5, customerId);
          System.out.println(stmt.toString());
          stmt.executeUpdate();
          return "SUCCESS";
      } catch(Exception e){
          e.printStackTrace();
          return "ERROR";
      }
    };
    public ArrayList<Booking> getBookings(int customerId){
        ArrayList<Booking> results = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM bookings WHERE customer=" + customerId;
            ResultSet resultSet = stmt.executeQuery(query);
            while(resultSet.next()){
                results.add(new Booking(
                        resultSet.getInt("id"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date"),
                        resultSet.getDate("registration_date"),
                        resultSet.getInt("room"),
                        resultSet.getInt("customer")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    };
    public String cancelBooking(int bookingId){
        try {
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM bookings WHERE id=" + bookingId;
            stmt.executeUpdate(query);
            return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
            return "FAILURE";
        }
    };
}
