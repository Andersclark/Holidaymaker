package io.andersclark.models;

import io.andersclark.db.Column;

public class Location {
    @Column("id")
    private final int id;
    @Column("location")
    private String location;
    @Column("pool")
    private boolean pool;
    @Column("evening_entertainment")
    private boolean evening_entertainment;
    @Column("daycare")
    private boolean daycare;

    public Location(int id, String location, boolean pool, boolean evening_entertainment, boolean daycare) {
        this.id = id;
        this.location = location;
        this.pool = pool;
        this.evening_entertainment = evening_entertainment;
        this.daycare = daycare;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isEvening_entertainment() {
        return evening_entertainment;
    }

    public void setEvening_entertainment(boolean evening_entertainment) {
        this.evening_entertainment = evening_entertainment;
    }

    public boolean isDaycare() {
        return daycare;
    }

    public void setDaycare(boolean daycare) {
        this.daycare = daycare;
    }
}
