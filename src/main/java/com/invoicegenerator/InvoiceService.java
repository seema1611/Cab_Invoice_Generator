package com.invoicegenerator;

public class InvoiceService {
    private static final double RS_PER_KILOMETER = 10;
    private static final int RS_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;
    public RideRepoisitory rideRepoisitory;

    public InvoiceService() {
        rideRepoisitory=new RideRepoisitory();
    }


    public double calculateFare(double distance, int time) {
        double totalFare = RS_PER_KILOMETER * distance + RS_PER_MINUTE * time;
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        } else {
            return totalFare;
        }
    }

    public double calculateCabFare(Ride[] rides) {
        double totalFare=0;
        for (Ride ride:rides)
        {
            totalFare+=this.calculateFare(ride.distance,ride.time);
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare=0;
        for (Ride ride:rides)
        {
            totalFare+=this.calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }


    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepoisitory.getRides(userId));
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepoisitory.addRides(userId,rides);
    }

}

