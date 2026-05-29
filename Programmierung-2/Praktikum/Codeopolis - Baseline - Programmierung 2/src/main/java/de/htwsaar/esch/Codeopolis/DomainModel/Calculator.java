package de.htwsaar.esch.Codeopolis.DomainModel;

public class Calculator {

    public int compute(int a, int b, BinaryOperation op) {
        return op.apply(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int x = 10;
        int y = 5;

        //Addition
        int sum = calculator.compute(x, y, new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        });
        System.out.println("Addition : " + sum);

        //Soustraction
        int diff = calculator.compute(x, y, new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        });
        System.out.println("Soustraction : " + diff);

        //Multiplication
        int prod = calculator.compute(x, y, new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        });
        System.out.println("Multiplication : " + prod);

        //Division
        int div = calculator.compute(x, y, new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a / b;
            }
        });
        System.out.println("Division : " + div);
    }
}