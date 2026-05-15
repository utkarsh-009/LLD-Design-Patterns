package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;

public class Vehicle {
    private final String licenseNumber;
    private final VehicleType vehicleType;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getLicensePlate() {
        return licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
