package Week10.FactoryMethod.src;

public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via PayPal");
        System.out.println("Redirecting to PayPal...");
        System.out.println("Payment successful!");
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}
