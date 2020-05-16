package com.invoicegenerator.test;

import com.invoicegenerator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceService invoiceService;
    RideRepository rideRepository;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
    }

    //Step-1
    //TC-1.1<----For Normal Ride---->
    @Test
    public void givenDistanceAndTimeNormalRides_whenProper_ShouldReturnTotalFare() {
        Ride[] rides = {
                new Ride(20.0, 25, CabRideCategory.NORMAL)
        };
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 225);
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    //TC-1.2<----For Normal Ride---->
    @Test
    public void givenLowDistanceAndTimeNormalRides_whenProper_ShouldReturnTotalFare() {
        Ride[] rides = {
                new Ride(0.1, 1, CabRideCategory.NORMAL),
        };
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 5);
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    //TC-1.3<----For Premium Ride---->
    @Test
    public void givenDistanceAndTimePremiumRides_whenProper_ShouldReturnTotalFare() {
        Ride[] rides = {
                new Ride(20.0, 25, CabRideCategory.PREMIUM)
        };
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 350);
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    //TC-1.4<----For Premium Ride---->
    @Test
    public void givenLowDistanceAndTimePremiumRides_whenProper_ShouldReturnTotalFare() {
        Ride[] rides = {
                new Ride(0.5, 1, CabRideCategory.PREMIUM)
        };
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 20);
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    //Step-2
    //TC-2.1<----For Normal Ride---->
    @Test
    public void givenMultipleNormalRides_whenProper_ShouldReturnTotalFare() {
        Ride[] rides = {
                new Ride(20.0, 25, CabRideCategory.NORMAL),
                new Ride(0.1, 1, CabRideCategory.NORMAL)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 230.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    //TC-2.2<----For Premium Ride---->
    @Test
    public void givenMultiplePremiumRides_whenProper_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(20.0, 25, CabRideCategory.PREMIUM),
                new Ride(0.1, 1, CabRideCategory.PREMIUM)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 370.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    //Step-3
    //TC-3.1<----For Normal Ride---->
    @Test
    public void givenUserIdAndMultipleNormalRides_whenProper_ShouldReturnInvoiceSummary() {
        String userId = "seema@123";
        Ride[] rides = {new Ride(20.0, 25, CabRideCategory.NORMAL),
                        new Ride(0.1, 1, CabRideCategory.NORMAL)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 230.0);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    //TC-3.2<----For Premium Ride---->
    @Test
    public void givenUserIdAndMultiplePremiumRides_whenProper_ShouldReturnInvoiceSummary() {
        String userId = "seema@123";
        Ride[] rides = {new Ride(20.0, 25, CabRideCategory.PREMIUM),
                        new Ride(0.1, 1, CabRideCategory.PREMIUM)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 370.0);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}