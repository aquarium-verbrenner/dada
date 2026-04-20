package de.htwsaar.esch.programming2.lambdas;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;

public class DataStructure {
	int[] a;
	
	public DataStructure(int size){
		a = new int[size];
		Random ran = new Random();
		for(int i=0; i<a.length; i++)
			a[i] = ran.nextInt(100);
	}
	
	public void sort(Comparator c){
		for (int i=a.length; i>0; i--){
			for (int j=0; j<a.length-1; j++){
				if (c.compare(a[j],a[j+1])>0){
					swap(j, j+1);
				} 
			}
		}	 
	}

	private void swap(int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;		
	}
	
	public void print()
	{
		System.out.println("print array:");
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+", ");
		System.out.println("\ndone");
	}
	


	
	//Aufgabe: Verarbeiten der Werte des Arrays mithilfe eines Consumers
	public void consumeArray( )
	{ 
			 
	}
	
	
	
	
	//Aufgabe: Setzen neuer Werte mithilfe eines Suppliers
	public void setNewValues( )
	{
	
	}
	
	
	
	//Aufgabe: Anwenden eines Operators auf die Werte des Arrays
	public void applyOperatorToArray( ){

	}
	
	
	
	//Aufgabe: Anwenden einer Funktion auf die Werte des Arrays und Rückgabe der Ergebnisse 
	public double[] applyFunctionToArray(  )
	{
		double[] results = new double[a.length];


		return results;
	}
	
	//Aufgabe: Filtern des Arrays mithilfe eines Predicate und Rückgabe der gefilterten Liste
	public ArrayList<Integer> filter(  )
	{
		ArrayList<Integer> result = new ArrayList<Integer>();


		return result;
	}
	
	
	//Aufgabe: Sortieren des Arrays mithilfe eines BiPredicate
	public void sort2(   ){
		for (int i=a.length; i>0; i--){
			for (int j=0; j<a.length-1; j++){
				//if (   )
					swap(j, j+1); 
			} 
		}	 
	}
	
	//Aufgabe: Sortieren des Arrays mithilfe eines IntBinaryOperator
	public void sort3(     ) {
		for (int i=a.length; i>0; i--){
			for (int j=0; j<a.length-1; j++){
				//if(      )
					swap(j, j+1);
			}
		}
	}
	
}
