public class PersonTestDrive {

    public static void main(String[] args) {

        Professor professor1 = new Professor();
        professor1.name = "Schneider";
        professor1.age = 99;
        professor1.fach = "Mathematik";
        professor1.personalNummer = 987654;
        professor1.greetProfessor();

        Professor professor2 = new Professor();
        professor2.name = "Klaus";
        professor2.age = 34;
        professor2.fach = "Datenbanken";
        professor2.personalNummer = 384709;
        professor2.greetProfessor();


        Student student1 = new Student();
        student1.name = "Dzevada";
        student1.age = 20;
        student1.studienGang = "Informatik";
        student1.matrikelNummer = 123456;
        student1.greetStudent();

        Person person1 = new Person();
        person1.name = "Valentin";
        person1.age = 19;
        person1.greet();
    }
}

