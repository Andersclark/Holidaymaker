package io.andersclark;

import io.andersclark.db.DB;
import io.andersclark.models.Booking;
import io.andersclark.models.Customer;
import io.andersclark.models.Room;
import io.andersclark.models.Search;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    Scanner userInput;
    DB db;

    public Client(){
        userInput = new Scanner(System.in);
        db = DB.getInstance();
        userPickMenuOption();
    }

    private void printMenu(){
        System.out.println("Choose option:");
        System.out.println("  1  Register new customer");
        System.out.println("  2  Book a room");
        System.out.println("  3  Cancel a booking");
        System.out.println("  4  Search for rooms");
        System.out.println("  5  Exit program");
    }

    private void userPickMenuOption(){
        printMenu();
        String option;
        option = userInput.nextLine();
        switch(option){
            case "1":
                System.out.println("You choose 1 -> Register new customer");
                inputCustomer();
                break;
            case "2":
                System.out.println("You choose 2 -> Book a room");
                inputSearch();
                break;
            case "3":
                System.out.println("You choose 3 -> Cancel a booking");
                cancelBooking();
                break;
            case "4":
                System.out.println("You choose 4 -> Search rooms");
                inputSearch();
                break;
            case "5":
                System.out.println("PROGRAM TERMINATING...");
                break;
            default:
                System.out.println("ERROR: PLEASE SELECT WITH ONE OF THE OPTION NUMBERS ABOVE");
                userPickMenuOption();
        }
    }
    private void printCustomers(){
        db.getAllCustomers();
    }

    private void inputCustomer(){
        Customer newCustomer = new Customer();
        System.out.println("INPUT FIRSTNAME");
        newCustomer.setFirstname(userInput.nextLine());
        System.out.println("INPUT LASTNAME");
        newCustomer.setLastname(userInput.nextLine());
        System.out.println("INPUT PHONENUMBER:");
        newCustomer.setPhone(userInput.nextLine());
        System.out.println("INPUT EMAIL:");
        newCustomer.setEmail(userInput.nextLine());
        System.out.println(newCustomer.toString());
        db.saveCustomer(newCustomer);
        printMenu();
    }

    private void inputSearch() {
        Search search = new Search();
        System.out.println("HOW MANY BEDS?");
        search.setBeds(Integer.parseInt(userInput.nextLine()));
        System.out.println("POOL?");
        search.setPool(userInput.nextLine().trim().equals("y"));
        System.out.println("DAYCARE?");
        search.setDaycare(userInput.nextLine().trim().equals("y"));
        System.out.println("EVENING ENTERTAINMENT?");
        search.setEvening_entertainment(userInput.nextLine().trim().equals("y"));
        ArrayList<Room> results = db.searchRooms(search);
        System.out.println("RESULTS:");
        for(int i = 1; i < results.size(); i++){
            System.out.println(i + " - " + results.get(i).toString());
        };
        System.out.println("Which room to book? 0 to cancel");
        String option;
        option = userInput.nextLine();
        switch(option){
            case "0":
                System.out.println("You choose 0 -> EXITING BOOKING MENU...");
                userPickMenuOption();
                break;
            default:
                System.out.println("You choose "
                        + option + "a "
                        + results.get(Integer.parseInt(option)).toString()
                        + "Do you wish to book? Y/N"
                );
                if(userInput.nextLine().trim().toLowerCase().equals("y")){
                    bookRoom(results.get(Integer.parseInt(option)).getId());
                }

        }
    }
    private void bookRoom(int roomId){
        System.out.println("BOOKING");
        System.out.println("Please enter customer ID");
        int customerId = userInput.nextInt();
        LocalDate startDate = inputStartDate();
        LocalDate endDate = inputEndDate();
        System.out.println(db.bookRoom(startDate, endDate, roomId, customerId));
        userPickMenuOption();
    }
    private LocalDate inputStartDate(){
        System.out.println("Input starting date (YYYY MM DD):");
        LocalDate startDate = LocalDate.of(userInput.nextInt(), userInput.nextInt(), userInput.nextInt());
        if(startDate.isBefore(Booking.BOOKABLE_FROM)){
            System.out.println("ERROR: Startdate is before beginning of season. Input a later date");
            startDate = inputStartDate();
        }
        return startDate;
    }
    private LocalDate inputEndDate(){
        System.out.println("Input end date (YYYY MM DD:");
        LocalDate endDate = LocalDate.of(userInput.nextInt(), userInput.nextInt(), userInput.nextInt());
        if(endDate.isAfter(Booking.BOOKABLE_TO)){
            System.out.println("ERROR: Enddate is after end of season. Input an earlier date");
            endDate = inputStartDate();
        }
        return endDate;
    }

    private void cancelBooking(){
        System.out.println("CANCEL BOOKING:");
        System.out.println("input customer id:");
        int customerId = userInput.nextInt();
        ArrayList<Booking> bookings = db.getBookings(customerId);
        for(int i = 1; i < bookings.size(); i++){
            System.out.println(i + " - " + bookings.get(i).toString());
        };
        System.out.println("Which booking would you like to cancel?");
        System.out.println(db.cancelBooking(userInput.nextInt()));
        userPickMenuOption();
    }
}
