package parkingLot;

import Entity.ParkingSpot;
import Entity.Ticket;
import Entity.Vehicle;
import pricing.CostComputation;

import java.time.LocalDateTime;
import java.util.List;


public class ParkingBuilding {
    private final List<ParkingLevel> levels;

    public ParkingBuilding(List<ParkingLevel> levels, CostComputation costComputationStrategy) {
        this.levels = levels;
    }
 

    Ticket allocate(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.hasAvailability(vehicle.getVehicleType())) {
                ParkingSpot parkingSpot = level.park(vehicle.getVehicleType());
                if (parkingSpot != null) {
                    Ticket ticket = new Ticket(vehicle.getVehicleNum(), vehicle, parkingSpot, LocalDateTime.now());
                    System.out.println("Allocated Parking Spot: " + parkingSpot.getSpotId() + " at Level: " + level.getLevelNumber());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("Parking Full for Vehicle Type: " + vehicle.getVehicleType());
    }
    
    void release(Ticket ticket) {
        if (ticket != null) {
            ticket.getParkingSpot().releaseSpot();
        }
    }

    
}
