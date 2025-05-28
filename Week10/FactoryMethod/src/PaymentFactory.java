package Week10.FactoryMethod.src;
// Creator (Factory)
public abstract class PaymentFactory {
    // Factory method - subclasses will implement this
    public abstract PaymentProcessor createPaymentProcessor();

    // Template method that uses the factory method
    public void processOrder(double amount) {
        PaymentProcessor processor = createPaymentProcessor();
        System.out.println("Selected payment method: " + processor.getPaymentMethod());
        processor.processPayment(amount);
        System.out.println("Order completed!\n");
    }
}
