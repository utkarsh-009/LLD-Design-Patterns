package com.parkinglot.strategy;

import com.parkinglot.model.ParkingSpot;
import java.util.List;

public class NearestLookupStrategy implements ParkingSpotLookupStrategy {
    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        return parkingSpots.stream()
                .filter(ParkingSpot::isFree)
                .findFirst()
                .orElse(null);
    }
}
