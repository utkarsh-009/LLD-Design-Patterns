package com.parkinglot.Entity;

import com.parkinglot.enums.VehicleType;

public class Vehicle {
    private String vehicleNum;
    VehicleType vehicleType;

    public Vehicle(String vehicleNum, VehicleType vehicleType) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
