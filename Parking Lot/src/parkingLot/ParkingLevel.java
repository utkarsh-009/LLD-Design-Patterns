package parkingLot;

import Entity.ParkingSpot;
import enums.VehicleType;
import spotManager.ParkingSpotManager;

import java.util.Map;

public class ParkingLevel {
    private int levelNumber;
    private final Map<VehicleType, ParkingSpotManager> managers;
    public ParkingLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> managers) {
        this.levelNumber = levelNumber;
        this.managers = managers;
    }

    public boolean hasAvailability(VehicleType vehicleType) {
        ParkingSpotManager manager = managers.get(vehicleType);
        return manager != null && manager.park() != null;
    }

    public ParkingSpot park(VehicleType vehicleType) {
        ParkingSpotManager manager = managers.get(vehicleType);
        if (manager == null) {
            throw new IllegalArgumentException("Vehicle Parking Not Supported for Vehicle Type: " + vehicleType);
        }
        return manager.park();
    }

    public void unpark(VehicleType vehicleType, ParkingSpot parkingSpot) {
        ParkingSpotManager manager = managers.get(vehicleType);
        if (manager == null) {
            throw new IllegalArgumentException("Vehicle Parking Not Supported for Vehicle Type: " + vehicleType);
        }
        manager.unpark(parkingSpot);
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
