package com.parkinglot.Entity;

public class ParkingSpot {
    String spotId;
    boolean free;

    boolean isFree() {
        return free;
    }

    String getSpotId() {
        return spotId;
    }

    void occupySpot() {
        free = false;
    }

    void releaseSpot() {
        free = true;
    }
}
