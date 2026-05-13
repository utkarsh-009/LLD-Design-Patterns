public class ParkingBuilding {
    private final List<ParkingLevel> levels;

    public ParkingBuilding(List<ParkingLevel> levels, CostComputationStrategy costComputationStrategy) {
        this.levels = levels;
    }
 

    Ticket allocate(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.hasAvailability(vehicle.getVehicleType())) {
                ParkingSpot parkingSpot = level.park(vehicle.getVehicleType());
                if (parkingSpot != null) {
                    Ticket ticket = new Ticket(vehicle, parkingSpot, level);
                    System.out.println("Allocated Parking Spot: " + parkingSpot.getSpotNumber() + " at Level: " + level.getLevelNumber());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("Parking Full for Vehicle Type: " + vehicle.getVehicleType());
    }
    
    void release(Ticket ticket) {
        if (ticket != null) {
            ticket.getLevel()
            .unpark(
                ticket.getVehicle().getVehicleType(), ticket.getParkingSpot());
        }
    }

    
}
