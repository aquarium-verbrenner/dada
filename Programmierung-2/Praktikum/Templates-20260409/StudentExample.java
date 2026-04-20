package de.htwsaar.esch.programming2.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.Collection;

class Student {
    String name;
    int age;
    double grade;

    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade=" + grade + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

public class StudentExample {

    public static void main(String[] args) {
    	Collection<Student> students = new ArrayList<>();       
        Student alice = new Student("Alice", 20, 3.5);
        Student bob = new Student("Bob", 19, 2.8);
        Student charlie = new Student("Charlie", 22, 3.9);
        Student david = new Student("David", 18, 2.4);
        Student eve = new Student("Eve", 21, 3.6);
        //Fügen Sie die Student-Objekte der ArrayList hinzu. 
        
        System.out.println("All students:");
        printStudents(students);

        int minAge = 20;
        // Entfernen Sie alle Studenten unter dem Mindestalter minAge
        System.out.println("\nStudents aged " + minAge + " or older:");
        printStudents(students);

        
        Student newStudent1 = new Student("Frank", 21, 3.7);
        Student newStudent2 = new Student("Alice", 20, 3.5);
        // Fügen Sie den neuen Studenten "Frank"und "Alice" hinzu, wenn sie nicht bereits in der Liste sind
        System.out.println("\nAfter adding new students:");
        printStudents(students);

        
        Student foundStudent // Finden Sie einen Studenten mit einem bestimmten Namen
        if(foundStudent != null)
        	System.out.println(foundStudent);
        
        System.out.println("\nUpdating grades:");
        // Erhöhen Sie die Noten aller Studenten um 0.5
        printStudents(students);

        System.out.println("\nNotifying students from 'Charlie':");
        notifyStudentsFrom(students, "Charlie");
        
        System.out.println("\nRemoving students with grades below 3.0:");
        // Entfernen Sie alle Studenten mit einer Note unter 3.0
        printStudents(students);
    }

    public static void printStudents(Collection<Student> students) {
        // Diese Methode gibt alle Studenten in der Konsole aus
        
    }

    public static void removeStudentsBelowAge(Collection<Student> students, int minAge) {
        // Diese Methode entfernt alle Studenten unter dem angegebenen Mindestalter
        // Nutzen Sie dabei einen Iterator
    }

    public static void addStudentIfAbsent(Collection<Student> students, Student newStudent) {
        // Diese Methode fügt einen neuen Studenten hinzu, wenn er nicht bereits in der Liste ist
        
    }

    public static Student findStudentByName(Collection<Student> students, String name) {
        // Diese Methode sucht nach einem Studenten mit einem bestimmten Namen und gibt ihn zurück, falls vorhanden
        
    }

    public static void notifyStudentsFrom(Collection<Student> students, String name) {
        // Diese Methode benachrichtigt alle verbleibenden Studenten ab einem bestimmten Namen. 
    	//Die Benachrichtigung soll einfach in Form einer Konsolenausgabe erfolgen: "Sending Notification to ... 
        
    }

    public static void updateGrades(Collection<Student> students, Consumer<Student> gradeUpdater) {
        // Diese Methode aktualisiert die Noten der Studenten basierend auf der übergebenen Funktion
        
    }
    
    public static void removeStudentsWithLowGrades(Collection<Student> students, double minGrade) {
        // Diese Methode entfernt alle Studenten mit einer Note unter der angegebenen Mindestnote
    	// Nutzen Sie removeIf
    }
}
