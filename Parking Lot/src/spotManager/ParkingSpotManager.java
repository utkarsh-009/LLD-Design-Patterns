package spotManager;

import Entity.ParkingSpot;
import LookupStrategy.ParkingSpotLookupStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {
    protected final List<ParkingSpot> parkingSpots;
    protected final ParkingSpotLookupStrategy lookupStrategy;
    private final ReentrantLock lock = new ReentrantLock(true);

    protected ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotLookupStrategy lookupStrategy) {
        this.parkingSpots = parkingSpots;
        this.lookupStrategy = lookupStrategy;
    }

    public ParkingSpot park() {
        lock.lock();
        try {
            ParkingSpot parkingSpot = lookupStrategy.selectSpot(parkingSpots);
            if (parkingSpot == null) {
                return null;
            }
            parkingSpot.occupySpot();
            return parkingSpot;
        } 
        finally {
            lock.unlock();
        }
    }

    public void unpark(ParkingSpot parkingSpot) {
        lock.lock();
        try {
            parkingSpot.releaseSpot();
        } 
        finally {
            lock.unlock();
        }
    }

    public boolean hasFreeSpot() {
        lock.lock();
        try {
            return parkingSpots.stream().anyMatch(ParkingSpot::isFree);
        }
        finally {
            lock.unlock();
        }
    }
}