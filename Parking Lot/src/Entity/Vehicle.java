package Entity;

import enums.VehicleType;

public class Vehicle {
    private String vehicleNum;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNum, VehicleType vehicleType) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
