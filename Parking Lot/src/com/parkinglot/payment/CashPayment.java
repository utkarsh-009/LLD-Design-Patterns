package com.parkinglot.payment;

public class CashPayment implements Payment {
    @Override
    public boolean makePayment(double amount) {
        System.out.println("Processing cash payment of amount: Rs. " + String.format("%.2f", amount));
        System.out.println("Cash payment successful!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "CASH";
    }
}
