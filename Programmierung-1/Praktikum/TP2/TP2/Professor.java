public class Professor extends Person {
    String fach;
    int personalNummer;
    
    void greetProfessor(){
        System.out.println("Hallo, ich heiße " + name + ", ich bin " + age + " Jahre alt und unterrichte " + fach + " mit der Personalnummer " + personalNummer + ".");
    }
}