package com.invoicegenerator;

public class InvoiceSummary
{
    private final int totalNumberOfRides;
    private final double totalFare;
    private final double avgFarePerRide;

    public InvoiceSummary(int totalNumberOfRides, double totalFare) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFare = totalFare;
        this.avgFarePerRide = this.totalFare/this.totalNumberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return totalNumberOfRides == that.totalNumberOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.avgFarePerRide, avgFarePerRide) == 0;
    }
}
