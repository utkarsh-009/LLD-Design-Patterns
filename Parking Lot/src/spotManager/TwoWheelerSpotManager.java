/**
 * 
 * 1. Maintains list of two wheeler parking spots only.
 * 2. Has its own lookup strategy.
 * 3. Has its own lock to avoid conflicts with four wheeler parking spot manager.
 */
public class TwoWheelerSpotManager extends ParkingSpotManager {
    public TwoWheelerSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotLookupStrategy lookupStrategy) {
        super(parkingSpots, lookupStrategy);
    }
}
