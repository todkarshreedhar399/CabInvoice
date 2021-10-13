package com.bl;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
	CabInvoiceGenerator cabInvoiceGenerator = null;

	@Before
	public void setup() throws Exception {
		cabInvoiceGenerator = new CabInvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTimeShouldReturnMaxFare() {
		double result = cabInvoiceGenerator.calculateFare(2.0, 5);
		Assert.assertEquals(25, result, 0.0);
	}

	@Test
	public void givenDistanceAndTimeShouldReturnMinFare() {
		double result = cabInvoiceGenerator.calculateFare(0.1, 1);
		Assert.assertEquals(5, result, 0.0);

	}

	@Test
	public void givenMultipleDistanceAndTimeShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}
