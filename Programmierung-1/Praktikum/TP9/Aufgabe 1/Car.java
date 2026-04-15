public class Car {
    public String brand;
    public String model;
    public String color;
    public int maxSpeed;

    public Car(String brand, String model, String color, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.color = "noire"; 
        this.maxSpeed = 180;   
    }

    public void printInfo(){
        System.out.println("La voitre " + brand + " qui est une " + model + " de couleur " + color + " a une vitesse maximale de " + maxSpeed + "km/h");
    }
}
