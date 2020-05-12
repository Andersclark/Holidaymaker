package io.andersclark.models;

public class Room {
    private int id;
    private int location;
    private int beds;
    private int price;

    public Room() {}

    public Room(int id, int location, int beds, int price) {
        this.id = id;
        this.location = location;
        this.beds = beds;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return beds + "-bed room for " + price + " per night.";
    }
}
