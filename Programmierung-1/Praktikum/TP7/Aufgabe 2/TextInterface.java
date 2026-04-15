public class TextInterface {
    public static void main(String[] args) {
        ConversionStrategy strategy = new CelsiusToFahrenheitStrategy(); 
        double inputValue = 20.0;
        double result = strategy.convert(inputValue);
        System.out.println("Résultat de la conversion: " + result);
    }
}
