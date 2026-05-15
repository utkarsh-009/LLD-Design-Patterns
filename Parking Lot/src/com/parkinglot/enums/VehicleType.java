package com.parkinglot.enums;

public enum VehicleType {
    TWO_WHEELER("Two Wheeler", 1),
    FOUR_WHEELER("Four Wheeler", 4);

    private final String displayName;
    private final int numWheels;

    VehicleType(String displayName, int numWheels) {
        this.displayName = displayName;
        this.numWheels = numWheels;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getNumWheels() {
        return numWheels;
    }
}
