package com.parkinglot.strategy;

import com.parkinglot.model.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {
    private final double hourlyRate;

    public HourlyPricingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateCost(Ticket ticket) {
        long durationMinutes = ticket.getDurationMinutes();
        long hours = (durationMinutes + 59) / 60;
        return hours * hourlyRate;
    }
}
