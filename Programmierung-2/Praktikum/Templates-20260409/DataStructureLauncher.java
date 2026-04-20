package de.htwsaar.esch.programming2.lambdas;

import java.util.function.BiPredicate;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;
import java.util.ArrayList;
import java.util.Random;

public class DataStructureLauncher {

	public static void main(String[] args) {
		
		Comparator anonymousInnerClass = new Comparator(){
			public int compare(int a, int b) {
				return b - a;
			}
		};
		Comparator lambda1 = (int a, int b) -> {
			return a -b;
		};
		
		Comparator lambda2 = (int a, int b) -> a-b;
		
		Comparator lambda3 = (a,b) -> a-b;
		
		Comparator lambda4 = (a,b) -> b-a;
		
		DataStructure ds = new DataStructure(30);
		ds.sort(lambda3);
		ds.print();
		
		ds = new DataStructure(30);
		ds.sort(lambda4);
		ds.print();
		
		ds = new DataStructure(30);
		ds.sort((a,b) -> b-a);
		ds.print();
		
	
		/*
		//Test consumeArray
		//Aufgabe: Ausgeben aller Werte größer 10 
		IntConsumer greater10  = 

		
		System.out.println("Values > 10:");
		ds.consumeArray(greater10);
		System.out.println("\ndone");
		
		//Aufgabe: Ausgeben aller Werte kleiner 50
		IntConsumer smaller50 = 
		System.out.println("Values < 50:");
		ds.consumeArray(smaller50);
		System.out.println("\ndone");
		
		//Aufgabe: Ausgeben aller Werte größer 10 und anschließend Ausgabe aller Werte kleiner 50.
		System.out.println("Values > 10 and Values < 50:");
		ds.consumeArray(    );
		System.out.println("\ndone");
		*/
		
		
		/*
		//Test setNewValues
		//Aufgabe: Implementieren eines IntSupplier, der zufällige Werte kleiner 100 liefert. 
		IntSupplier is = 

		System.out.println("\nOld Values:");
		ds.print();
		ds.setNewValues(is);
		System.out.println("\nNew Values:");
		ds.print();
		*/
		
		
		/*
		//Test applyOperatorToArray
		//Aufgabe: Implementieren eines Operators, der alle Werte mit 2 multipilziert.
		IntUnaryOperator by2 ;
		ds.applyOperatorToArray(by2);
		System.out.println("\nValues after :x -> x*2");
		ds.print();
		*/
				
		/*
		//Test applyFunctionToArray	
		//Aufgabe: Implementieren einer Funktion, die alle Werte mit PI multipilziert. 	
		IntToDoubleFunction byPI
		double[] results = ds.applyFunctionToArray(byPI);
		for(int i=0; i<30; i++)
			System.out.print(results[i]+", ");
		*/
		
		
		/*
		//Test filter
		Aufgabe: Implementieren eines Predikats, welches nur Werte zwischen 100 und 300 zulässt. 
		IntPredicate intPred1 = 
		
		Aufgabe: Implementieren eines Predikats, welches nur Werte zwischen 400 und 500 zulässt. 
		IntPredicate intPred2 =            
		
		Aufgabe: Implementieren eines Predikats, welches die beiden oberen Prädikate mit einer ODER-Verknüpfung kombiniert.
		IntPredicate or = 

		System.out.println("\nFiltered Numbers");
		ArrayList<Integer> specificNumbers = ds.filter(intPred1);
		for(Integer i : specificNumbers)
			System.out.print(i+", ");
		System.out.println("----");
		specificNumbers = ds.filter(or);
		for(Integer i : specificNumbers)
			System.out.print(i+", ");
		*/
			    
		/*	    
		//Comperator as BiPredicate
		//Aufgabe: Implementierung eines BiPredicate, welches zwei Zahlen vergleicht. 
		 
		ds.sort2( );
		ds.print();
		*/
				
		
	}

}
