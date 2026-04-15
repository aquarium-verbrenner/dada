public class PaymentMethod {
    private String holder;

    public PaymentMethod(String holder) {
        this.holder = holder;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void processPayment(double amount) {
        System.out.print(holder + " paid " + amount + " EUR.");
        System.out.printf("%s paid %.2f EUR.\n", getHolder(), amount);
    }

    public void refundPayment(double amount) {
        System.out.print(holder + " received a refund of " + amount + " EUR.");
    }
}