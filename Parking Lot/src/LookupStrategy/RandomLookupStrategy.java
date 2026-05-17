package LookupStrategy;

import Entity.ParkingSpot;

import java.util.List;
import java.util.Random;

public class RandomLookupStrategy implements ParkingSpotLookupStrategy {

    private final Random random = new Random();

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {

        List<ParkingSpot> freeSpots = parkingSpots.stream()
                .filter(ParkingSpot::isFree)
                .toList();

        if (freeSpots.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(freeSpots.size());

        return freeSpots.get(randomIndex);
    }
}