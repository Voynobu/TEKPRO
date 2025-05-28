package Week10.Adapter.src;

public class PaymentAdapter implements PaymentProcessor{
    private  ThirdPartyPaymentGateway thirdPartyGateway;

    public PaymentAdapter(ThirdPartyPaymentGateway gateway){
        this.thirdPartyGateway = gateway;
    }

    @Override
    public boolean processPayment(double amount, String currency) {

        String result = thirdPartyGateway.makePayment(String.valueOf(amount), currency);
        return result != null;
    }

    @Override
    public String getgTransactionId() {
        return thirdPartyGateway.getLastTransactionReference();
    }
}
