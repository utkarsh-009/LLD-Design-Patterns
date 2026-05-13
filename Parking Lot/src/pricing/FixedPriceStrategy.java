public class FixedPriceStrategy implements PricingStrategy {
    private final double fixedPrice;

    public FixedPriceStrategy(double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    @Override
    public double calculateCost(Ticket ticket) {
        return fixedPrice;
    }
}
