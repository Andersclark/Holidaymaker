package io.andersclark.models;


import java.time.LocalDate;

public class Search {
    private int beds;
    private boolean pool;
    private boolean evening_entertainment;
    private boolean daycare;
    private LocalDate startDate;
    private LocalDate endDate;

    public Search() {}

    public Search(int beds, boolean pool, boolean evening_entertainment, boolean daycare, LocalDate startDate, LocalDate endDate) {
        this.beds = beds;
        this.pool = pool;
        this.evening_entertainment = evening_entertainment;
        this.daycare = daycare;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
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
