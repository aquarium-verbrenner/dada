package de.htwsaar.esch.programming2.lambdas;


public class Juggler {

	public interface Handler {

		public void handle(double value);
		
	}
	
	public class AverageBuilder implements Handler {
		
		int count;
		double sum;
		
		public void handle(double value) {
			++count;
			sum+= value;
		}
		
		public double getAverage() {
			return sum / count; 
		}

	}
	
	/**
	 * Nimmt ein Handler-Objekt entgegen und wendet den Handler auf alle Elemente eines double-Arrays an. 
	 * @param handler
	 */
	public void juggleWithNumbers(Handler handler) {
		double values[] = { 1.0, 5.0, 3.0 };

		for (double v : values) {
			handler.handle(v);
		}
	}

	/**
	 * Handler as top level class
	 */
	public void firstExample() {
		AverageBuilder averageBuilder = new AverageBuilder();

		System.out.println("First example (average):");
		juggleWithNumbers(averageBuilder);
		System.out.println("average is " + averageBuilder.getAverage());
	}

	/**
	 * Handler as anonymous class.
	 */
	public void secondExample() {
		System.out.println("Second handler example (system.out.println):");
		juggleWithNumbers(new Handler() {
			public void handle(double value) {
				System.out.println(value);
			}
		});
	}
	
	/**
	 * Handler as anonymous class that accesses final variables of the enclosing statement block
	 */
	public void thirdExample() {
		final double min = 2.0;
		final double max = 4.0;
		
		System.out.println("Third handler example (Min, Max):");
		juggleWithNumbers(new Handler() {
			public void handle(double value) {
				if (value >= min && value <= max)
					System.out.println(value);
			}

		});
		
		System.out.println("Third handler example (Max): ");
		juggleWithNumbers(new Handler() {
			public void handle(double value) {
				if (value <= max)
					System.out.println(value);
			}

		});
	}
	
	public void fourthExample(){
	/*
		Aufgabe: Rufen Sie die Methode juggleWithNumbers mit verschiedenen Handlern auf, die 	folgendes machen:
			- Ausgabe der jeweiligen Werte
			- Ausgabe der Quadratzahlen der Werte
			- Ausgabe aller Zahlen kleiner 4
		Implementieren Sie die Handler jeweils als anonyme Klasse und als Lambda-Ausdruck
	*/
		
	}
	
	public static void main(String[] args) {
		Juggler j = new Juggler();
		
		j.firstExample();
		j.secondExample();
		j.thirdExample();
		j.fourthExample();
	}
}
