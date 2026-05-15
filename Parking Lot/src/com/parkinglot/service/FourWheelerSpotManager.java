package com.parkinglot.service;

import com.parkinglot.model.ParkingSpot;
import com.parkinglot.strategy.ParkingSpotLookupStrategy;
import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager {
    public FourWheelerSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotLookupStrategy lookupStrategy) {
        super(parkingSpots, lookupStrategy);
    }
}
