public class CashPayment implements Payment {
    @Override
    public void pay(Ticket ticket) {
        System.out.println("Processing cash payment for ticket: " + ticket.getId());
    }

    @Override
    public boolean makePayment(double amount) {
        System.out.println("Processing cash payment of: " + amount);
        return true;
    }
}
