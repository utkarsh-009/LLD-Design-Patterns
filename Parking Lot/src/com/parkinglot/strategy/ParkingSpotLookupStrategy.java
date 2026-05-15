package com.parkinglot.strategy;

import com.parkinglot.model.ParkingSpot;
import java.util.List;

public interface ParkingSpotLookupStrategy {
    ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);
}
