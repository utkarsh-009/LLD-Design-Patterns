package com.parkinglot.service;

import com.parkinglot.model.Ticket;
import com.parkinglot.strategy.PricingStrategy;

public class CostCalculator {
    private final PricingStrategy pricingStrategy;

    public CostCalculator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateCost(Ticket ticket) {
        return pricingStrategy.calculateCost(ticket);
    }
}
