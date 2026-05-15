package com.parkinglot.service;

import com.parkinglot.model.ParkingSpot;
import com.parkinglot.strategy.ParkingSpotLookupStrategy;
import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager {
    public TwoWheelerSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotLookupStrategy lookupStrategy) {
        super(parkingSpots, lookupStrategy);
    }
}
