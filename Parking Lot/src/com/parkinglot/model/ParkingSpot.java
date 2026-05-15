package com.parkinglot.model;

import com.parkinglot.enums.ParkingSpotType;

public class ParkingSpot {
    private final String spotId;
    private final int floorNumber;
    private final ParkingSpotType spotType;
    private volatile boolean occupied;

    public ParkingSpot(String spotId, int floorNumber, ParkingSpotType spotType) {
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.spotType = spotType;
        this.occupied = false;
    }

    public synchronized boolean isFree() {
        return !occupied;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getSpotNumber() {
        return spotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public synchronized void occupy() {
        if (occupied) {
            throw new IllegalStateException("Spot " + spotId + " is already occupied");
        }
        this.occupied = true;
    }

    public synchronized void release() {
        if (!occupied) {
            throw new IllegalStateException("Spot " + spotId + " is not occupied");
        }
        this.occupied = false;
    }

    public void occupySpot() {
        occupy();
    }

    public void releaseSpot() {
        release();
    }

    public void freeSpot() {
        release();
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId='" + spotId + '\'' +
                ", floorNumber=" + floorNumber +
                ", occupied=" + occupied +
                '}';
    }
}
