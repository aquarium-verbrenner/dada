import java.text.NumberFormat;
import java.util.Locale;

public class SpeedOfLight {
    public static final long VITESSE = 299792458L;

    public static double fraction(double factor) {
        if (factor < 0 || factor > 1) {
            throw new IllegalArgumentException("Le facteur doit être compris entre 0 et 1.");
        }
        return VITESSE * factor;
    }
    public static void printFraction(double factor) {
        double result = fraction(factor);
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(result) + " m/s");
    }
}
