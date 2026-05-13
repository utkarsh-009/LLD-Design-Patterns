package parkingLot;

import Entity.Vehicle;
import Ticket;

public class EntryGate {
    public Ticket enter(ParkingBuilding building, Vehicle vehicle) {
        return building.allocate(vehicle);
    }
}
