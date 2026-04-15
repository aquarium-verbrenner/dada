public class GooglePay extends PaymentMethod {

    public GooglePay(String holder) {
        super(holder);
    }

    @Override
    public void processPayment(double amount) {
        System.out.print(getHolder() + " paid " + amount + " EUR using Google Pay.");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.print(getHolder() + " received a refund of " + amount + " EUR via Google Pay.");
    }
}