package Week10.Adapter.src;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Object Adaptern Pattern Demo ===\n");

        ThirdPartyPaymentGateway thirdPartyGateway = new ThirdPartyPaymentGateway();
        PaymentProcessor adapter = new PaymentAdapter(thirdPartyGateway);
        PaymentService paymentService = new PaymentService(adapter);

        System.out.println("1. Processing a valid payment: ");
        paymentService.handlePayment(99.99, "USD");

        System.out.println("\n2. Processing an invalid payment");
        paymentService.handlePayment(-10.0, "EUR");

        System.out.println("\n3. Direct Adapter usage: ");
        boolean result = adapter.processPayment(250.0, "GBP");
        System.out.println("Direct call result: " + result);
        System.out.println("Transaction ID: " + adapter.getgTransactionId());
    }
}