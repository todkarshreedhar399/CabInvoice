package com.bl;

public class CabInvoiceGenerator {
	private final int MINFARE = 5;
	private final int COSTPERKM = 10;
	private final int COSTPERMIN = 1;

	public double calculateFare(double distance, int time) {
		double totalFare = COSTPERKM * distance + COSTPERMIN * time;
		return Math.max(totalFare,MINFARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length,totalFare);
	}
}
