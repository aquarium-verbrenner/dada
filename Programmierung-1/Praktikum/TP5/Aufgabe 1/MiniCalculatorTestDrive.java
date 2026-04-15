import java.util.Scanner;

public class MiniCalculatorTestDrive {
    public static void main(String[] args) {
        MiniCalculator calcul1 = new MiniCalculator();
        Scanner input = new Scanner(System.in);

        System.out.println("Select an operator (+, - , * and /) :");
        String operator = input.nextLine().trim();

        System.out.println("Select first number :");
        calcul1.value1 = input.nextInt();

        System.out.println("Select second number :");
        calcul1.value2 = input.nextInt();

        input.close();
        System.out.println("Result :");

        if (operator.trim().equals("+")) {
            calcul1.add();
        
        } else if (operator.equals("-")){
            calcul1.substract();

        } else if (operator.equals("*")){
            calcul1.multiply();
        
        } else if (operator.trim().equals("/")) {

            if (calcul1.value2 > 0) {
                calcul1.divide();

            } else {
                System.out.println("Cannot divide by 0 or inferior.");
            }

        } else {
            System.out.println("Wrong operator used (Reminder : Use only +, -, * and / ) !");
        }
    }
    
}
