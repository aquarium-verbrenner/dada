public class BreakDemo {
    public static void main(String[] args) {
        int[] nombres = {10, 20, 30, 40, 50, 60, 70};
        boolean found = false;

        for (int nombre : nombres) {
            if (nombre > 50) {
                System.out.println("Found " + nombre);
                found = true;

                break;
            }
        }

        if (!found) {
            System.out.println("Not found.");
        }
    }
}