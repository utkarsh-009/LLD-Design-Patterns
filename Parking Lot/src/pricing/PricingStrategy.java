package pricing;

import Entity.Ticket;

public interface PricingStrategy {
    double calculateCost(Ticket ticket);
}
