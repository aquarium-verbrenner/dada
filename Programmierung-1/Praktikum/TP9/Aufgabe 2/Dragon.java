public class Dragon extends Animal {

    private int firePower = 10;

    public Dragon() {
        this.setName("");
    }

    @Override
    public void makeSound() {
        System.out.printf("%s roars and spits fire with a power of %d.\n", this.getName(), firePower);
    }
}
