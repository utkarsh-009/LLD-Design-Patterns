package com.parkinglot.gate;

import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.exception.ParkingFullException;
import com.parkinglot.service.VehicleRepository;

public class EntryGate implements Gate {
    private final ParkingFloor floor;
    private final VehicleRepository vehicleRepository;

    public EntryGate(ParkingFloor floor, VehicleRepository vehicleRepository) {
        this.floor = floor;
        this.vehicleRepository = vehicleRepository;
    }

    public Ticket entry(Vehicle vehicle) {
        if (!floor.hasAvailability(vehicle.getVehicleType())) {
            throw new ParkingFullException(vehicle.getVehicleType().getDisplayName());
        }

        Ticket ticket = floor.allocateSpot(vehicle);
        vehicleRepository.addVehicle(vehicle);
        vehicleRepository.addTicket(vehicle.getLicenseNumber(), ticket);

        System.out.println("Entry Gate: Vehicle " + vehicle.getLicenseNumber() + " entered parking lot");
        System.out.println("Allocated Spot: " + ticket.getParkingSpot().getSpotId() + " on Floor: " + ticket.getFloorNumber());
        return ticket;
    }
}
