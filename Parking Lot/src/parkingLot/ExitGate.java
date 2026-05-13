public class ExitGate {

    private final CostComputation costComputation;

    public ExitGate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }

    void completeExit(ParkingBuilding building, Ticket ticket, Payment payment) {
        double amount = calculateCost(ticket);
        boolean paymentSuccessful = payment.makePayment(amount);

        if (!paymentSuccessful) {
            throw new RuntimeException("Payment Failed. Cannot exit the parking lot.");
        } 
        building.release(ticket);
        System.out.println("Exit Completed for Vehicle: " + ticket.getVehicle().getLicensePlate() + ". Amount Paid: " + amount);
    }

    private double calculateCost(Ticket ticket) {
        return costComputation.computeCost(duration);
    }
}
