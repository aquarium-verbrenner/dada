public class Student extends Person {
    String studienGang;
    int matrikelNummer;
    
    void greetStudent(){
        System.out.println("Hallo, ich heiße " + name + ", ich bin " + age + " Jahre alt und studiere " + studienGang + " mit der Matrikelnummer " + matrikelNummer + ".");
    }
}