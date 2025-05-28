package Week10.FactoryMethod.src;
public class BankTransferFactory extends PaymentFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new BankTransferProcessor();
    }
}