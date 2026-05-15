package com.parkinglot.exception;

public class PaymentFailedException extends ParkingLotException {
    private static final long serialVersionUID = 1L;

    public PaymentFailedException(double amount) {
        super("Payment failed for amount: " + amount);
    }
}
