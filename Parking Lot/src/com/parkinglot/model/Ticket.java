package com.parkinglot.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;
    private final int floorNumber;
    private LocalDateTime exitTime;
    private double costAmount;
    private boolean exited;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
        this.floorNumber = parkingSpot.getFloorNumber();
        this.exited = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public double getCostAmount() {
        return costAmount;
    }

    public boolean isExited() {
        return exited;
    }

    public void markExit(LocalDateTime exitTime, double costAmount) {
        this.exitTime = exitTime;
        this.costAmount = costAmount;
        this.exited = true;
    }

    public long getDurationMinutes() {
        if (exitTime == null) {
            return java.time.temporal.ChronoUnit.MINUTES.between(entryTime, LocalDateTime.now());
        }
        return java.time.temporal.ChronoUnit.MINUTES.between(entryTime, exitTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", costAmount=" + costAmount +
                ", exited=" + exited +
                '}';
    }
}
