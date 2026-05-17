package payment;

import Entity.Ticket;

public class UPIPayment implements Payment {
    @Override
    public void pay(Ticket ticket) {
        System.out.println("Processing UPI payment for ticket: " + ticket.getTicketId());
    }

    @Override
    public boolean makePayment(double amount) {
        System.out.println("Processing UPI payment of: " + amount);
        return true;
    }
}
