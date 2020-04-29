package io.andersclark.models;

import java.util.Date;

public class Booking {
    private final int id;
    private Date start_date;
    private Date end_date;
    private Customer customer;
    private Room room;

    public Booking(int id, Date start_date, Date end_date, Customer customer, Room room) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.customer = customer;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
