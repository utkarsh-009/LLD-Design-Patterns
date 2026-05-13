public interface Payment {
    void pay(Ticket ticket);
    boolean makePayment(double amount);
}
