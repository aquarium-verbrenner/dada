public class CarTestDrive {

    public static void main(String[] args) {
        Car myCar = new Car("Mercedes", "500E", "noire", 250);
        myCar.printInfo(); 

        Car myDefaultCar = new Car("Nissan", "LEAF");
        myDefaultCar.printInfo(); 

        ElectricCar mercedes = new ElectricCar("Mercedes", "EQB", "noire", 280, 95 );
        mercedes.printInfo();

        ElectricCar nissan = new ElectricCar("Nissan", "Leaf");
        nissan.printInfo();

    }
}