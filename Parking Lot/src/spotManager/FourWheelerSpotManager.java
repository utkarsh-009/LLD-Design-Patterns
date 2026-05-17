package spotManager;

import Entity.ParkingSpot;
import LookupStrategy.ParkingSpotLookupStrategy;
import spotManager.ParkingSpotManager;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager {
    public FourWheelerSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotLookupStrategy lookupStrategy) {
        super(parkingSpots, lookupStrategy);
    }
}
