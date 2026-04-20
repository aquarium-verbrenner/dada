package de.htwsaar.esch.programming2

import java.util.function.BiFunction;
import java.util.function.Function;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

public class MethodenreferenzenUebung {

    public static void main(String[] args) {
        Person person = new Person("Alice", 25);

        // 1. Rufen Sie die Methode performOperationOnString mit einer statischen Methodenreferenz auf.
        // Die referenzierte Methode soll die Länge eines Strings zurückgeben.

        // 2. Rufen Sie die Methode performOperationOnPerson mit einer Objekt-Methodenreferenz auf, die auf
        // die getName-Methode des person-Objekts verweist.

        // 3. Rufen Sie die Methode performOperationOnPersonAndAge mit einer Typ-Methodenreferenz auf, die auf
        // die setAge-Methode der Person-Klasse verweist. 

        // 4. Rufen Sie die Methode createNewPerson mit einer Methodenreferenz auf, die auf
        // den Konstruktor der Person-Klasse verweist.
        Person newPerson 
        System.out.println("Kopierte Person: " + newPerson);
    }

    private static void performOperationOnString(String str, Function<String, Integer> strOperation) {
        int result = strOperation.apply(str);
        System.out.println("Länge von '" + str + "': " + result);
    }

    private static void performOperationOnPerson(Person person, Function<Person, String> personOperation) {
        String result = personOperation.apply(person);
        System.out.println("Name der Person: " + result);
    }

    private static void performOperationOnPersonAndAge(Person person, int age, BiFunction<Person, Integer, Void> personAgeOperation) {
        personAgeOperation.apply(person, age);
        System.out.println("Person nach Altersänderung: " + person);
    }

    private static Person createNewPerson(Person person, Function<Person, Person> personConstructor) {
        return personConstructor.apply(person);
    }
}