package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.service.ParkingSpotManager;
import java.util.Map;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<VehicleType, ParkingSpotManager> spotManagers;
    private final DisplayBoard displayBoard;

    public ParkingFloor(int floorNumber, Map<VehicleType, ParkingSpotManager> spotManagers, DisplayBoard displayBoard) {
        this.floorNumber = floorNumber;
        this.spotManagers = spotManagers;
        this.displayBoard = displayBoard;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public boolean hasAvailability(VehicleType vehicleType) {
        ParkingSpotManager manager = spotManagers.get(vehicleType);
        return manager != null && manager.hasAvailability();
    }

    public Ticket allocateSpot(Vehicle vehicle) {
        ParkingSpotManager manager = spotManagers.get(vehicle.getVehicleType());
        if (manager == null) {
            throw new IllegalArgumentException("Vehicle type " + vehicle.getVehicleType() + " not supported on this floor");
        }

        ParkingSpot spot = manager.findAndAllocate();
        if (spot == null) {
            throw new RuntimeException("Unable to allocate parking spot");
        }

        Ticket ticket = new Ticket(vehicle, spot);
        displayBoard.decrementAvailableSpots("Floor-" + floorNumber, vehicle.getVehicleType());
        return ticket;
    }

    public void releaseSpot(ParkingSpot parkingSpot) {
        try {
            parkingSpot.release();
        } catch (Exception e) {
            System.err.println("Error releasing spot: " + e.getMessage());
        }
    }

    public void printFloorStatus() {
        System.out.println("\n========== FLOOR " + floorNumber + " STATUS ==========");
        spotManagers.forEach((vehicleType, manager) -> {
            System.out.println(vehicleType.getDisplayName() + ": " + manager.getAvailableCount() + "/" + manager.getTotalCount() + " available");
        });
        System.out.println("==================================\n");
    }
}
