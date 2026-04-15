public class KilometerToMileStrategy implements ConversionStrategy {
    @Override
    public double convert(double value) {
        return value * 0.621371;
    }

    @Override
    public String getDescription() {
        return "Kilometer zu Meilen";
    }
}
