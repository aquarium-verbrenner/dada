public class MileToKilometerStrategy implements ConversionStrategy {
    @Override
    public double convert(double value) {
        return value * 1.60934;
    }

    @Override
    public String getDescription() {
        return "Meilen zu Kilometer";
    }
}