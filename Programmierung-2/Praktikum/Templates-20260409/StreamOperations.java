package de.htwsaar.esch.programming2.collections.streams;


import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
    	//Nutzen Sie für alle Aufgaben Streams. 
        
    	//Erstellen Sie ein Set of Integer und fügen Sie 10 Werte hinzu. 
        Set<Integer> numbers . . .

        // Filtern Sie die Zahlen heraus, die größer als 10 sind und 
        //speichern Sie diese in einem neuen Set filteredNumbers
        Set<Integer> filteredNumbers = . . .

        // Erhöhen Sie jede Zahl in der gefilterten Menge um 5. Speichern 
        //Sie die Ergebnisse in dem Set mappedNumbers.
        Set<Integer> mappedNumbers = . . .

        // Sortieren Sie die Zahlen in dem Set mappedNumbers in aufsteigender
        //Reihenfolge und speichern Sie das Ergebniss in der Liste sortedNumbers 
        List<Integer> sortedNumbers = . . .

        // Berechnen Sie die Summe der Zahlen in dem Set mappedNumbers
        int sum . . .
        
        //Führen Sie alle obigen Schritte filter, map und sort in einer 
        //Verkettung von Stream-Operationen aus (Fluent Programming) und speichern 
        //Sie das Ergebnis in einem Set.
        Set<Integer> newSet = . . .
        

        //Ausgabe
        System.out.println("Ursprüngliche Menge: " + numbers);
        System.out.println("Gefilterte und transformierte, sortierte Zahlen: " + sortedNumbers);
        System.out.println("Summe der transformierten Zahlen: " + sum);
        System.out.println("Neue Menge der transformierten Zahlen: " + newSet);
    }
}
