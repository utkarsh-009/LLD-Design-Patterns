package LookupStrategy;

import java.util.List;

import com.parkinglot.Entity.ParkingSpot;

public interface ParkingSpotLookupStrategy {
    ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);
}
