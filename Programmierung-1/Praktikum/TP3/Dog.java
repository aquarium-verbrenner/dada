public class Dog {
  
  int age;
  String breed;
  String name;

  void bark() {
    System.out.println(name + " barks: Ruff! Ruff!");
  }

  public void printDog(){
    System.out.println("Dog Name: " + name + ", Breed: " + breed + ", Age: " + age);
  }

}
