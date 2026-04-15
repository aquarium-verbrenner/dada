public class FahrenheitToCelsiusStrategy implements ConversionStrategy {
    @Override
    public double convert(double value) {
        return (value - 32) / 1.8;
    }

    @Override
    public String getDescription() {
        return "Fahrenheit zu Celsius";
    }
}
