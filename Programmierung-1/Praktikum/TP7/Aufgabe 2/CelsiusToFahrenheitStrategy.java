public class CelsiusToFahrenheitStrategy extends ConversionStrategy {

    @Override
    public double convert(double value) {
        return (value * 1.8) + 32; // 
    }
}
