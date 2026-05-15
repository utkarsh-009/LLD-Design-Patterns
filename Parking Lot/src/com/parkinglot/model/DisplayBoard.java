package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DisplayBoard {
    private final Map<String, Integer> availableSpots;
    private final Map<String, Integer> totalSpots;

    public DisplayBoard() {
        this.availableSpots = new ConcurrentHashMap<>();
        this.totalSpots = new ConcurrentHashMap<>();
    }

    public void addFloor(String floorId, VehicleType vehicleType, int spotCount) {
        String key = floorId + "_" + vehicleType.name();
        totalSpots.put(key, spotCount);
        availableSpots.put(key, spotCount);
    }

    public synchronized void decrementAvailableSpots(String floorId, VehicleType vehicleType) {
        String key = floorId + "_" + vehicleType.name();
        availableSpots.put(key, availableSpots.getOrDefault(key, 0) - 1);
    }

    public synchronized void incrementAvailableSpots(String floorId, VehicleType vehicleType) {
        String key = floorId + "_" + vehicleType.name();
        availableSpots.put(key, availableSpots.getOrDefault(key, 0) + 1);
    }

    public int getAvailableSpots(String floorId, VehicleType vehicleType) {
        String key = floorId + "_" + vehicleType.name();
        return availableSpots.getOrDefault(key, 0);
    }

    public void printAvailability() {
        System.out.println("\n========== PARKING LOT AVAILABILITY ==========");
        availableSpots.forEach((key, count) -> {
            System.out.println("Floor: " + key + " -> Available: " + count);
        });
        System.out.println("=============================================\n");
    }
}
