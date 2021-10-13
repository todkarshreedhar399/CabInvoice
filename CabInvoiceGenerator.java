package com.bl;

public class CabInvoiceGenerator {
	 private final int MINFARE = 5;
	    private final int COSTPERKM = 10;
	    private final int COSTPERMIN = 1;

	    public double calculateFare(double distance, int time) {
	        double totalFare = COSTPERKM * distance + COSTPERMIN * time;
	        if (totalFare < MINFARE) {
	            return MINFARE;
	        }
	        return totalFare;
	    }	
}
