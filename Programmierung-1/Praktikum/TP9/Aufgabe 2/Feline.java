public abstract class Feline extends Animal {

    public Feline(String name) {
        this.setName(name);
    }

    @Override
    public void eat() {
        System.out.printf("%s licked its paws.\n", this.getName());
    }
    @Override
    public void makeSound() {
        System.out.printf("%s made a noise.\n", this.getName());
    }
}