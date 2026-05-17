package parkingLot;

import Entity.Ticket;
import Entity.Vehicle;
import payment.Payment;

public class ParkingLot {
    private final ParkingBuilding building;
    private final EntryGate entryGate;
    private final ExitGate exitGate;

    public ParkingLot(ParkingBuilding building, EntryGate entryGate, ExitGate exitGate) {
        this.building = building;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle) {
        return entryGate.enter(building, vehicle);
    }

    public void vehicleExits(Ticket ticket, Payment payment) {
        exitGate.completeExit(building, ticket, payment);
    }

}
