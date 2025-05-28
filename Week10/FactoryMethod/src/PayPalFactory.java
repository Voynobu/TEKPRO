package Week10.FactoryMethod.src;
public class PayPalFactory extends PaymentFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new PayPalProcessor();
    }
}