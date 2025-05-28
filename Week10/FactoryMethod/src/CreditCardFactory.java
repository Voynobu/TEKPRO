package Week10.FactoryMethod.src;
// Concrete Creators
public class CreditCardFactory extends PaymentFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new CreditCardProcessor();
    }
}
