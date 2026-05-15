package com.parkinglot.payment;

public interface Payment {
    boolean makePayment(double amount);
    String getPaymentMethod();
}
