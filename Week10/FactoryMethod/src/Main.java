package Week10.FactoryMethod.src;
public class Main{
    public static void main(String[] args) {
        // Customer chooses different payment methods

        PaymentFactory factory;

        // Scenario 1: Customer pays with credit card
        factory = new CreditCardFactory();
        factory.processOrder(99.99);

        // Scenario 2: Customer pays with PayPal
        factory = new PayPalFactory();
        factory.processOrder(149.50);

        // Scenario 3: Customer pays with bank transfer
        factory = new BankTransferFactory();
        factory.processOrder(299.00);
    }
}