package com.parkinglot.service;

import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.model.DisplayBoard;
import com.parkinglot.gate.EntryGate;
import com.parkinglot.gate.ExitGate;
import com.parkinglot.payment.Payment;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private final List<ParkingFloor> floors;
    private final EntryGate entryGate;
    private final ExitGate exitGate;
    private final VehicleRepository vehicleRepository;
    private final DisplayBoard displayBoard;

    public ParkingLotManager(List<ParkingFloor> floors, EntryGate entryGate, ExitGate exitGate, 
                           VehicleRepository vehicleRepository, DisplayBoard displayBoard) {
        this.floors = floors;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.vehicleRepository = vehicleRepository;
        this.displayBoard = displayBoard;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        return entryGate.entry(vehicle);
    }

    public void unparkVehicle(Ticket ticket, Payment payment) {
        exitGate.exit(ticket, payment);
    }

    public void displayAvailability() {
        displayBoard.printAvailability();
    }

    public void displayFloorStatus(int floorNumber) {
        if (floorNumber > 0 && floorNumber <= floors.size()) {
            floors.get(floorNumber - 1).printFloorStatus();
        }
    }

    public void displayAllFloorsStatus() {
        for (ParkingFloor floor : floors) {
            floor.printFloorStatus();
        }
    }

    public boolean isVehicleParked(String licenseNumber) {
        return vehicleRepository.isVehicleParked(licenseNumber);
    }

    public Ticket getTicket(String licenseNumber) {
        return vehicleRepository.getTicket(licenseNumber);
    }
}
