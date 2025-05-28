package Week10.FactoryMethod.src;
public class BankTransferProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Bank Transfer");
        System.out.println("Initiating ACH transfer...");
        System.out.println("Payment successful!");
    }

    @Override
    public String getPaymentMethod() {
        return "Bank Transfer";
    }
}

