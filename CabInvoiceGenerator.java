public class CabInvoiceGenerator {
    private final int MINFARE = 5;
    private final int COSTPERKM = 10;
    private final int COSTPERMIN = 1;

    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time) {
        double totalFare = COSTPERKM * distance + COSTPERMIN * time;
        if (totalFare < MINFARE) {
            return MINFARE;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
