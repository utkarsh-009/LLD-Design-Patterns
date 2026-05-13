public class UPIPayment implements Payment {
    @Override
    public void pay(Ticket ticket) {
    System.out.println("Processing UPI payment for ticket: " + ticket.getId());}

}
