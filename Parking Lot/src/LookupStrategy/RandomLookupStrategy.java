package LookupStrategy;

import java.util.List;
import com.parkinglot.Entity.ParkingSpot;
import java.util.Random;

public class RandomLookupStrategy implements ParkingSpotLookupStrategy {
    private final Random random = new Random();

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        return parkingSpots.stream()
                .filter(ParkingSpot::isFree)
                .skip(random.nextInt((int) parkingSpots.stream().filter(ParkingSpot::isFree).count()))
                .findFirst()
                .orElse(null);
    }
}