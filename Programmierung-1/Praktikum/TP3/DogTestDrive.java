public class DogTestDrive {
    public static void main(String[] args) {
        int num1 = 2;
        System.out.println(num1);
        int num2 = num1;
        System.out.println(num2);
        num1 = 3;
        System.out.println(num1);
        System.out.println(num2);

        Dog nullDog = new Dog();
        System.out.println(nullDog);

        Dog dog1 = new Dog();
        dog1.age = 2;
        dog1.breed = "Berger Australien";
        dog1.name = "Youmi";
        System.out.println("Mon chien s'appelle " + dog1.name + ", il a " + dog1.age + " ans et c'est un " + dog1.breed + ".");
        dog1.bark();

        Dog dog2 = dog1;
        dog2.age = 12;
        dog2.breed = "Jagt terrier";
        dog2.name = "Stab";
        System.out.println("Mon chien s'appelle " + dog2.name + ", il a " + dog2.age + " ans et c'est un " + dog2.breed + ".");
        dog2.printDog();
        dog2.bark();

        Dog[] dogs = {dog1, dog2};
        for (Dog dog : dogs) {
            System.out.println(dog.name + " est un " + dog.breed + " et il a " + dog.age + " ans.");
            dog.printDog();
            dog.bark();
        }
    }

}
