import java.util.List;
import java.util.Scanner;

public class TextInterface {
    private List<ConversionStrategy> strategies =
    List.of(
        new CelsiusToFahrenheitStrategy(),
        new FahrenheitToCelsiusStrategy(),
        new KilometerToMileStrategy(),
        new MileToKilometerStrategy());

    public void demarrer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Conversion =====");

        for (int i = 0; i < strategies.size(); i++) {
            System.out.println((i + 1) + ") " + strategies.get(i).getDescription());
        }

        System.out.print("\nPlease choose an option : ");
        int choix = scanner.nextInt();

        if (choix > 0 && choix <= strategies.size()) {
            ConversionStrategy selection = strategies.get(choix - 1);
            
            System.out.print("Enter a value to convert : ");
            double valeur = scanner.nextDouble();
            
            double resultat = selection.convert(valeur);
            System.out.println("Ther result is : " + resultat);
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new TextInterface().demarrer();
    }
}