package com.parkinglot.factory;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.service.FourWheelerSpotManager;
import com.parkinglot.service.ParkingSpotManager;
import com.parkinglot.service.TwoWheelerSpotManager;
import com.parkinglot.strategy.ParkingSpotLookupStrategy;
import java.util.List;

public class ParkingSpotManagerFactory {
    public static ParkingSpotManager createManager(VehicleType vehicleType, List<ParkingSpot> spots, 
                                                    ParkingSpotLookupStrategy lookupStrategy) {
        switch (vehicleType) {
            case TWO_WHEELER:
                return new TwoWheelerSpotManager(spots, lookupStrategy);
            case FOUR_WHEELER:
                return new FourWheelerSpotManager(spots, lookupStrategy);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}
