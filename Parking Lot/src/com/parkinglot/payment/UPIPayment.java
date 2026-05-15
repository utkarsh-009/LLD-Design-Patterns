package com.parkinglot.payment;

public class UPIPayment implements Payment {
    @Override
    public boolean makePayment(double amount) {
        System.out.println("Processing UPI payment of amount: Rs. " + String.format("%.2f", amount));
        System.out.println("UPI payment successful!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "UPI";
    }
}
