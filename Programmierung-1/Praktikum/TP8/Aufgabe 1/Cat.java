public class Cat extends Feline implements Pet {

    public Cat() {
        super("");
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Miaou !");
    }

    @Override
    public void play() {
        System.out.printf("%s plays with a ball of yarn.\n", this.getName());
    }
}