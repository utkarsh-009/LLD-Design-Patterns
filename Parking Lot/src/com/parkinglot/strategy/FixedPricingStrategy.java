package com.parkinglot.strategy;

import com.parkinglot.model.Ticket;

public class FixedPricingStrategy implements PricingStrategy {
    private static final double HOURLY_RATE = 50.0;

    @Override
    public double calculateCost(Ticket ticket) {
        return HOURLY_RATE;
    }
}
