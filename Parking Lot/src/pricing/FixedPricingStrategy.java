package pricing;

public class FixedPricingStrategy implements PricingStrategy {
    private static final double FIXED_RATE = 50.0;

    @Override
    public double calculateCost(Ticket ticket) {
        return FIXED_RATE;
    }
}