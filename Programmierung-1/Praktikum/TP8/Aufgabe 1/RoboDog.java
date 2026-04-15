public class RoboDog extends Robot implements Pet {
    private boolean isCharged;

    public RoboDog() {
        this.setModel("");
    }

    public boolean getCharge() {
        return isCharged;
    } 

    public void setCharge(boolean charge) {
        this.isCharged = charge;
    }

    @Override
    public void performTask() {
        if (isCharged) {
            System.out.printf("%s performed a task.\n", this.getModel());
        } else {
            System.out.printf("%s must be charged to do this.\n", this.getModel());
        }
    }

    public void play() {
        if (isCharged) {
            System.out.printf("%s fetches a ball.\n", this.getModel());
        } else {
            System.out.printf("%s must be charged to do this.\n", this.getModel());
        }
    }
}