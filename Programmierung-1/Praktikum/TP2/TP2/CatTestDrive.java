public class CatTestDrive {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Carlson";
        cat1.coatColor = "black";
        cat1.remainingLives = 7;
        System.out.print(cat1.name + ", the cat");
        System.out.print(" with " + cat1.coatColor + " fur");
        System.out.println(" and " + cat1.remainingLives + " lives left, says:");
        cat1.meow();
    }

}
