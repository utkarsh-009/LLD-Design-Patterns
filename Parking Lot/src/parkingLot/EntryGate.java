package parkingLot;


import Entity.Ticket;
import Entity.Vehicle;

public class EntryGate {
    public Ticket enter(ParkingBuilding building, Vehicle vehicle) {
        return building.allocate(vehicle);
    }
}
