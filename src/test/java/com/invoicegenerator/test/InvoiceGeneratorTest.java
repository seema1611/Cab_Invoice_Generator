package com.invoicegenerator.test;

import com.invoicegenerator.InvoiceGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator;

    @Before
    public void Initialize() {
        invoiceGenerator = new InvoiceGenerator();
    }

    //Step-1
    //TC-1.1
    @Test
    public void givenDistanceAndTime_whenInvoiceGenerator_shouldReturnCorrectTotalFare() {
        double distance=20.0;
        int time=25;
        double fare = invoiceGenerator.calculateCabFare(distance,time);
        Assert.assertEquals(225,fare,0.0);
    }

    //TC-1.2
    @Test
    public void givenDistanceAndTime_whenInvoiceGenerator_shouldReturnIncorrectTotalFare() {
        double distance=20.0;
        int time=25;
        double fare = invoiceGenerator.calculateCabFare(distance,time);
        Assert.assertNotEquals(25,fare,0.0);
    }
}
