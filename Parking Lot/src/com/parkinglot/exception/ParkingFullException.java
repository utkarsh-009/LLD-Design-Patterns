package com.parkinglot.exception;

public class ParkingFullException extends ParkingLotException {
    private static final long serialVersionUID = 1L;

    public ParkingFullException(String vehicleType) {
        super("Parking lot is full for " + vehicleType);
    }
}
