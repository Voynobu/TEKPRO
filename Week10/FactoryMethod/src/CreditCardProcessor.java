package Week10.FactoryMethod.src;
// Concrete Products
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Credit Card");
        System.out.println("Connecting to bank gateway...");
        System.out.println("Payment successful!");
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}