public class EntryGate {
    Ticket enter(ParkingBuilding building, Vehicle vehicle) {
        return building.allocate(vehicle); 
    }
}
