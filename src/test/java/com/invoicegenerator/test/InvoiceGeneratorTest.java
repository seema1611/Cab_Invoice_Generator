package com.invoicegenerator.test;

import com.invoicegenerator.InvoiceService;
import com.invoicegenerator.InvoiceSummary;
import com.invoicegenerator.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceService invoiceService=null;

    @Before
    public void setup() {
        invoiceService = new InvoiceService();
    }

    //Step-1
    //TC-1.1
    @Test
    public void givenDistanceAndTime_WhenProper_shouldReturnCorrectTotalFare() {
        double distance=20.0;
        int time=25;
        double fare = invoiceService.calculateFare(distance,time);
        Assert.assertEquals(225,fare,0.0);
    }

    //TC-1.2
    @Test
    public void givenDistanceAndTime_WhenImProper_shouldReturnIncorrectTotalFare() {
        double distance=0.1;
        int time=1;
        double fare = invoiceService.calculateFare(distance,time);
        Assert.assertNotEquals(25,fare,0.0);
    }

    //Step-2
    //TC-2.1
    @Test
    public void givenMultipleRides_WhenProper_shouldReturnCorrectTotalFare() {
        Ride[]rides={
                new Ride(20.0,25),
                new Ride(0.1,1)
        };
        double fare= invoiceService.calculateCabFare(rides);
        Assert.assertEquals(230,fare,0.0);
    }

    //TC-2.2
    @Test
    public void givenMultipleRides_WhenImProper_shouldReturnInCorrectTotalFare() {
        Ride[]rides={
                new Ride(20.0,25),
                new Ride(0.1,1)
        };
        double fare = invoiceService.calculateCabFare(rides);
        Assert.assertNotEquals(350,fare,0.0);
    }

    //Step-3
    //TC-3.1
    @Test
    public void givenMultipleRides_WhenProper_ShouldReturnCorrectInvoiceSummary() {
        Ride[] rides={
                new Ride(20.0,25),
                new Ride(0.1,1)
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedSummary=new InvoiceSummary(2,230);
        Assert.assertEquals(invoiceSummary, expectedSummary);
    }

    //TC-3.2
    @Test
    public void givenMultipleRides_WhenImProper_ShouldReturnInCorrectInvoiceSummary() {
        Ride[] cabRides = {
                new Ride(20.0, 25),
                new Ride(0.1, 1)
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(cabRides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 200);
        Assert.assertNotEquals(invoiceSummary, expectedSummary);
    }
}
