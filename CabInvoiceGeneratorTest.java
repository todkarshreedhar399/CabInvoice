package com.bl;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

	@Test
	public void givenDistanceAndTimeShouldReturnMaxFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double result = cabInvoiceGenerator.calculateFare(15, 30);
		Assert.assertEquals(180, result, 0.0);
	}

	@Test
	public void givenDistanceAndTimeShouldReturnMinFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double result = cabInvoiceGenerator.calculateFare(0.1, 1);
		Assert.assertEquals(5, result, 0.0);

	}

	@Test
	public void givenMultipleDistanceAndTimeShouldReturnTotalFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double fare = cabInvoiceGenerator.calculateFare(rides);
		Assert.assertEquals(30, fare, 0.0);
	}
}
