public class AnimalTestDrive {
    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("Test : Dragon");
        System.out.println("==============================================");

        Dragon dragon = new Dragon();
        dragon.setName("Douglas");
        dragon.makeSound();
        dragon.eat();

        System.out.println("==============================================");
        System.out.println("Test : Cat");
        System.out.println("==============================================");

        Cat cat = new Cat();
        cat.setName("Mimi");
        cat.makeSound();
        cat.eat();
        cat.play();

        System.out.println("==============================================");
        System.out.println("Test : Dog");
        System.out.println("==============================================");

        Dog dog = new Dog();
        dog.setName("Youmi");
        dog.makeSound();
        dog.eat();
        dog.play();

        System.out.println("==============================================");
        System.out.println("Test : Lion");
        System.out.println("==============================================");

        Lion lion = new Lion();
        lion.setName("Simba");
        lion.makeSound();
        lion.eat();

        System.out.println("==============================================");
        System.out.println("Test : Wolf");
        System.out.println("==============================================");

        Wolf wolf = new Wolf();
        wolf.setName("James");
        wolf.makeSound();
        wolf.eat();

        System.out.println("==============================================");
        System.out.println("Test : RoboDog");
        System.out.println("==============================================");

        RoboDog roboDog = new RoboDog();
        roboDog.setModel("T-1000");

        System.out.println("Test 1 : setCharged = true");
        System.out.println("==============================================");

        roboDog.setCharge(true);
        roboDog.performTask();
        roboDog.play();

        System.out.println("==============================================");
        System.out.println("Test 2 : setCharged = false");
        System.out.println("==============================================");
        
        roboDog.setCharge(false);
        roboDog.performTask();
        roboDog.play();
    }
}