package com.parkinglot.factory;

import com.parkinglot.payment.CardPayment;
import com.parkinglot.payment.CashPayment;
import com.parkinglot.payment.Payment;
import com.parkinglot.payment.UPIPayment;

public class PaymentFactory {
    public static Payment createPayment(String paymentType) {
        switch (paymentType.toUpperCase()) {
            case "CASH":
                return new CashPayment();
            case "UPI":
                return new UPIPayment();
            case "CARD":
                return new CardPayment("****-****-****-1234", "John Doe");
            default:
                throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
    }
}
