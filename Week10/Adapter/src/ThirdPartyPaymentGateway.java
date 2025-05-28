package Week10.Adapter.src;

public class ThirdPartyPaymentGateway {
    private String lastTransactionRef;

    public String makePayment(String amountStr, String currencyCode){

        System.out.println("ThirdPartyGateway: Processing payment of " + amountStr + " "+ currencyCode);

        if (Double.parseDouble(amountStr) > 0){
            this.lastTransactionRef = "TXN_" + System.currentTimeMillis();
            System.out.println("Payment Successful. Transaction ID : " + this.lastTransactionRef);
            return this.lastTransactionRef;
        } else {
            System.out.println("Payment failed: invalid amount");
            return null;
        }
    }

    public String getLastTransactionReference(){
        return this.lastTransactionRef;
    }
}
