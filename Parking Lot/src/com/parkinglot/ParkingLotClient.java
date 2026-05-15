package com.parkinglot;

import com.parkinglot.enums.*;
import com.parkinglot.factory.*;
import com.parkinglot.gate.*;
import com.parkinglot.model.*;
import com.parkinglot.payment.*;
import com.parkinglot.service.*;
import com.parkinglot.strategy.*;
import java.util.*;

public class ParkingLotClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n========================================");
        System.out.println("    PARKING LOT MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        DisplayBoard displayBoard = new DisplayBoard();

        ParkingSpotLookupStrategy lookupStrategy = new RandomLookupStrategy();

        ParkingFloor floor1 = createFloor(1, displayBoard, lookupStrategy);
        ParkingFloor floor2 = createFloor(2, displayBoard, lookupStrategy);
        
        List<ParkingFloor> floors = Arrays.asList(floor1, floor2);

        VehicleRepository vehicleRepository = new VehicleRepository();
        CostCalculator costCalculator = new CostCalculator(new HourlyPricingStrategy(50.0));

        EntryGate entryGate = new EntryGate(floor1, vehicleRepository);
        ExitGate exitGate = new ExitGate(floor1, costCalculator, vehicleRepository);

        ParkingLotManager parkingLotManager = new ParkingLotManager(floors, entryGate, exitGate, vehicleRepository, displayBoard);

        simulateParkingOperations(parkingLotManager);
    }

    private static ParkingFloor createFloor(int floorNumber, DisplayBoard displayBoard, ParkingSpotLookupStrategy lookupStrategy) {
        Map<VehicleType, ParkingSpotManager> spotManagers = new HashMap<>();

        List<ParkingSpot> twoWheelerSpots = createParkingSpots(
                Arrays.asList(
                        "F" + floorNumber + "-2W-1",
                        "F" + floorNumber + "-2W-2",
                        "F" + floorNumber + "-2W-3"
                ),
                floorNumber,
                ParkingSpotType.COMPACT
        );

        List<ParkingSpot> fourWheelerSpots = createParkingSpots(
                Arrays.asList(
                        "F" + floorNumber + "-4W-1",
                        "F" + floorNumber + "-4W-2",
                        "F" + floorNumber + "-4W-3",
                        "F" + floorNumber + "-4W-4"
                ),
                floorNumber,
                ParkingSpotType.LARGE
        );

        spotManagers.put(
                VehicleType.TWO_WHEELER,
                ParkingSpotManagerFactory.createManager(VehicleType.TWO_WHEELER, twoWheelerSpots, lookupStrategy)
        );
        spotManagers.put(
                VehicleType.FOUR_WHEELER,
                ParkingSpotManagerFactory.createManager(VehicleType.FOUR_WHEELER, fourWheelerSpots, lookupStrategy)
        );

        ParkingFloor floor = new ParkingFloor(floorNumber, spotManagers, displayBoard);

        displayBoard.addFloor("Floor-" + floorNumber, VehicleType.TWO_WHEELER, twoWheelerSpots.size());
        displayBoard.addFloor("Floor-" + floorNumber, VehicleType.FOUR_WHEELER, fourWheelerSpots.size());

        return floor;
    }

    private static List<ParkingSpot> createParkingSpots(List<String> spotIds, int floorNumber, ParkingSpotType spotType) {
        List<ParkingSpot> spots = new ArrayList<>();
        for (String spotId : spotIds) {
            spots.add(new ParkingSpot(spotId, floorNumber, spotType));
        }
        return spots;
    }

    private static void simulateParkingOperations(ParkingLotManager parkingLotManager) throws InterruptedException {
        System.out.println("========== SCENARIO 1: MULTIPLE VEHICLES ENTRY ==========\n");

        Vehicle bike1 = new Vehicle("BK-001", VehicleType.TWO_WHEELER);
        Vehicle car1 = new Vehicle("CR-001", VehicleType.FOUR_WHEELER);
        Vehicle bike2 = new Vehicle("BK-002", VehicleType.TWO_WHEELER);
        Vehicle car2 = new Vehicle("CR-002", VehicleType.FOUR_WHEELER);

        Ticket ticket1 = parkingLotManager.parkVehicle(bike1);
        Ticket ticket2 = parkingLotManager.parkVehicle(car1);
        Ticket ticket3 = parkingLotManager.parkVehicle(bike2);
        Ticket ticket4 = parkingLotManager.parkVehicle(car2);

        parkingLotManager.displayAvailability();
        parkingLotManager.displayAllFloorsStatus();

        System.out.println("========== SCENARIO 2: VEHICLE EXIT WITH PAYMENT ==========\n");

        Thread.sleep(2000);

        System.out.println("--- Vehicle 1 (Bike) Exit ---");
        Payment cashPayment = PaymentFactory.createPayment("CASH");
        parkingLotManager.unparkVehicle(ticket1, cashPayment);

        System.out.println("--- Vehicle 2 (Car) Exit ---");
        Payment upiPayment = PaymentFactory.createPayment("UPI");
        parkingLotManager.unparkVehicle(ticket2, upiPayment);

        parkingLotManager.displayAvailability();

        System.out.println("========== SCENARIO 3: MORE VEHICLES PARKED ==========\n");

        Vehicle bike3 = new Vehicle("BK-003", VehicleType.TWO_WHEELER);
        Vehicle car3 = new Vehicle("CR-003", VehicleType.FOUR_WHEELER);

        Ticket ticket5 = parkingLotManager.parkVehicle(bike3);
        Ticket ticket6 = parkingLotManager.parkVehicle(car3);

        parkingLotManager.displayAvailability();

        System.out.println("========== SCENARIO 4: REMAINING VEHICLES EXIT ==========\n");

        Thread.sleep(2000);

        System.out.println("--- Vehicle 3 (Bike) Exit ---");
        Payment cardPayment = PaymentFactory.createPayment("CARD");
        parkingLotManager.unparkVehicle(ticket3, cardPayment);

        System.out.println("--- Vehicle 4 (Car) Exit ---");
        parkingLotManager.unparkVehicle(ticket4, cashPayment);

        System.out.println("--- Vehicle 5 (Bike) Exit ---");
        parkingLotManager.unparkVehicle(ticket5, upiPayment);

        System.out.println("--- Vehicle 6 (Car) Exit ---");
        parkingLotManager.unparkVehicle(ticket6, cardPayment);

        parkingLotManager.displayAvailability();
        parkingLotManager.displayAllFloorsStatus();

        System.out.println("========================================");
        System.out.println("    PARKING LOT SIMULATION COMPLETED");
        System.out.println("========================================\n");
    }
}
