public class ElectricCar extends Car {
    public int batteryCapacity;

    public ElectricCar(String brand, String model, String color, int maxSpeed, int batteryCapacity) {
        super(brand, model, color, maxSpeed); 
        this.batteryCapacity = batteryCapacity;
    }

    public ElectricCar(String brand, String model) {
        super(brand, model, "noire", 180); 
        this.batteryCapacity = 60;
    }

    @Override
    public void printInfo() {
        super.printInfo(); 
        System.out.println("Batterie : " + batteryCapacity + " kWh");
    }
}


