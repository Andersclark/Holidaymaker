package io.andersclark.models;

import java.sql.Date;
import java.time.LocalDate;


public class Booking {
    public static final LocalDate BOOKABLE_FROM = LocalDate.of(2020, 5, 31);
    public static final LocalDate BOOKABLE_TO = LocalDate.of(2020, 8, 1);
    private int id;
    private Date start_date;
    private Date end_date;
    private int customer;
    private int room;

    public Booking() {}

    public Booking(int id, Date start_date, Date end_date, Date booking_date, int customer, int room) {
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

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return id
                + ": ROOM " + room + " booked from " + start_date.toLocalDate().toString() + " to " + end_date.toLocalDate().toString();
    }
}
