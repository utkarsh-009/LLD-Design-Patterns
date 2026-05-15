package com.parkinglot.payment;

public class CardPayment implements Payment {
    private final String cardNumber;
    private final String cardholderName;

    public CardPayment(String cardNumber, String cardholderName) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
    }

    @Override
    public boolean makePayment(double amount) {
        System.out.println("Processing card payment of amount: Rs. " + String.format("%.2f", amount));
        System.out.println("Card ending with: " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Card payment successful!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "CARD";
    }
}
