package com.parkinglot.strategy;

import com.parkinglot.model.Ticket;

public interface PricingStrategy {
    double calculateCost(Ticket ticket);
}
