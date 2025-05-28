package Week10.FactoryMethod.src;

// Product interface
interface PaymentProcessor {
    void processPayment(double amount);
    String getPaymentMethod();
}