package com.invoicegenerator;

public class Ride {
    public final double distance;
    public final int time;
    public CabRideCategory category;

    public Ride(double distance, int time, CabRideCategory category) {
        this.distance = distance;
        this.time = time;
        this.category=category;
    }
}