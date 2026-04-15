public class PayPal extends PaymentMethod {

    public PayPal(String holder) {
        super(holder);
    }

    @Override
    public void processPayment(double amount) {
        System.out.print(getHolder() + " paid " + amount + " EUR using PayPal.");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.print(getHolder() + " received a refund of " + amount + " EUR via PayPal.");
    }
}