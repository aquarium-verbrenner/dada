public class KilometerToMileStrategy extends ConversionStrategy {
    private static final double MILES_PER_KM = 0.621371;
    
    @Override
    public double convert(double value) {
        return value * MILES_PER_KM;
    }
}
