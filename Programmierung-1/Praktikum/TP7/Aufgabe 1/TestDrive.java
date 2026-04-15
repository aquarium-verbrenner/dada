import java.util.ArrayList;

public class TestDrive {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard("Jana");
        PaymentMethod payPal = new PayPal("Florian");
        PaymentMethod googlePay = new GooglePay("Charlie");

        double paymentAmount = 100.00;
        double refundAmount = 50.00;

        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(creditCard);
        paymentMethods.add(payPal);
        paymentMethods.add(googlePay);

        System.out.println("Test : Paiement");
        for (PaymentMethod method : paymentMethods) {
            method.processPayment(paymentAmount);
        }

        System.out.println("Test : Remboursement");
        for (PaymentMethod method : paymentMethods) {
            method.refundPayment(refundAmount);
        }
    }
}
