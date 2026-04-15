public class CelsiusToFahrenheitStrategy implements ConversionStrategy {

    @Override
    public double convert(double value) {
        return (value * 1.8) + 32;
    }

    @Override
    public String getDescription() {
        return "Celsius zu Fahrenheit";
    }
}
