package io.andersclark.models;

import io.andersclark.db.Column;

public class Room {
    @Column("id")
    private final int id;
    @Column("location")
    private Location location;
    @Column("beds")
    private int beds;
    @Column("price")
    private int price;

    public Room(int id, Location location, int beds, int price) {
        this.id = id;
        this.location = location;
        this.beds = beds;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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
}
