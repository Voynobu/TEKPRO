package Week10.Adapter.src;

public interface PaymentProcessor {
    boolean processPayment(double amount, String currency);
    String getgTransactionId();
}
