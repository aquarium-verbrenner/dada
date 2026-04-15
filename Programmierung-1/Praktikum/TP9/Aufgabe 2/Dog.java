public class Dog extends Canine implements Pet {

    public Dog() {
        super("");
    }

    @Override
    public void makeSound() {
        System.out.println("Ouaf !");
    }

    @Override
    public void play() {
        System.out.printf("%s fetches a ball.\n", this.getName());
    }
}