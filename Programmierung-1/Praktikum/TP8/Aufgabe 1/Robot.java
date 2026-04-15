public abstract class Robot {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void performTask() {
        System.out.printf("%s performed a task.\n", model);
    }
}