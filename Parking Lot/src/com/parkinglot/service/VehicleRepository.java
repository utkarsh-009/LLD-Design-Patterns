package com.parkinglot.service;

import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleRepository {
    private final Map<String, Ticket> ticketMap;
    private final Map<String, Vehicle> vehicleMap;

    public VehicleRepository() {
        this.ticketMap = new ConcurrentHashMap<>();
        this.vehicleMap = new ConcurrentHashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getLicenseNumber(), vehicle);
    }

    public Vehicle getVehicle(String licenseNumber) {
        return vehicleMap.get(licenseNumber);
    }

    public void addTicket(String vehicleId, Ticket ticket) {
        ticketMap.put(vehicleId, ticket);
    }

    public Ticket getTicket(String vehicleId) {
        return ticketMap.get(vehicleId);
    }

    public Ticket removeTicket(String vehicleId) {
        return ticketMap.remove(vehicleId);
    }

    public boolean isVehicleParked(String vehicleId) {
        return ticketMap.containsKey(vehicleId);
    }
}
