package com.parkinglot.gate;

import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.Ticket;
import com.parkinglot.payment.Payment;
import com.parkinglot.service.CostCalculator;
import com.parkinglot.service.VehicleRepository;
import com.parkinglot.exception.PaymentFailedException;
import java.time.LocalDateTime;

public class ExitGate implements Gate {
    private final ParkingFloor floor;
    private final CostCalculator costCalculator;
    private final VehicleRepository vehicleRepository;

    public ExitGate(ParkingFloor floor, CostCalculator costCalculator, VehicleRepository vehicleRepository) {
        this.floor = floor;
        this.costCalculator = costCalculator;
        this.vehicleRepository = vehicleRepository;
    }

    public void exit(Ticket ticket, Payment payment) {
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket");
        }

        double cost = costCalculator.calculateCost(ticket);
        boolean paymentSuccessful = payment.makePayment(cost);

        if (!paymentSuccessful) {
            throw new PaymentFailedException(cost);
        }

        ticket.markExit(LocalDateTime.now(), cost);
        floor.releaseSpot(ticket.getParkingSpot());
        vehicleRepository.removeTicket(ticket.getVehicle().getLicenseNumber());

        System.out.println("\nExit Gate: Vehicle " + ticket.getVehicle().getLicensePlate() + " exited parking lot");
        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("Amount Paid: Rs. " + String.format("%.2f", cost));
        System.out.println("======================================\n");
    }
}
