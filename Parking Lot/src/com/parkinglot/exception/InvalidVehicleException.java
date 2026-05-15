package com.parkinglot.exception;

public class InvalidVehicleException extends ParkingLotException {
    private static final long serialVersionUID = 1L;

    public InvalidVehicleException(String licenseNumber) {
        super("Invalid vehicle: " + licenseNumber);
    }
}
