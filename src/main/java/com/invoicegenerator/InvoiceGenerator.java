package com.invoicegenerator;

public class InvoiceGenerator {

    public static final int COST_PER_MINUTE=1;
    public static final double COST_PER_KILOMETER=10;
    public static final double MINIMUM_FARE=5;

    public double calculateCabFare(double distance, int time) {
        double totalFare = ((distance * COST_PER_KILOMETER) + (time * COST_PER_MINUTE));
        if(totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        } else {
            return totalFare;
        }
    }
}
