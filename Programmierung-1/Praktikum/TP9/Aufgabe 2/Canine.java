public abstract class Canine extends Animal {

    public Canine(String name) {
        this.setName(name);
    }

    @Override
    public void eat() {
        System.out.printf("%s howls.\n", this.getName());
    }
}
