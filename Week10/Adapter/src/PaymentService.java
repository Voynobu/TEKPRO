package Week10.Adapter.src;

public class PaymentService {
    private PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor){
        this.processor = processor;
    }

    public void handlePayment(double amount, String currency){
        System.out.println("PaymentService: Initiating payment...");

        boolean success = processor.processPayment(amount, currency);

        if (success){
            String transcactionId = processor.getgTransactionId();
            System.out.println("PaymentService: Payment Complete Successfully!");
            System.out.println("Transaction ID: " + transcactionId);
        } else {
            System.out.println("SystemService Payment Failed");
        }
    }
}
