package com.parkinglot.service;

import com.parkinglot.model.ParkingSpot;
import com.parkinglot.strategy.ParkingSpotLookupStrategy;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class ParkingSpotManager {
    protected final List<ParkingSpot> parkingSpots;
    protected final ParkingSpotLookupStrategy lookupStrategy;
    protected final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    protected ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotLookupStrategy lookupStrategy) {
        this.parkingSpots = parkingSpots;
        this.lookupStrategy = lookupStrategy;
    }

    public ParkingSpot findAndAllocate() {
        lock.writeLock().lock();
        try {
            ParkingSpot spot = lookupStrategy.selectSpot(parkingSpots);
            if (spot != null) {
                spot.occupy();
            }
            return spot;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void release(ParkingSpot parkingSpot) {
        lock.writeLock().lock();
        try {
            parkingSpot.release();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean hasAvailability() {
        lock.readLock().lock();
        try {
            return parkingSpots.stream().anyMatch(ParkingSpot::isFree);
        } finally {
            lock.readLock().unlock();
        }
    }

    public int getAvailableCount() {
        lock.readLock().lock();
        try {
            return (int) parkingSpots.stream().filter(ParkingSpot::isFree).count();
        } finally {
            lock.readLock().unlock();
        }
    }

    public int getTotalCount() {
        return parkingSpots.size();
    }
}
