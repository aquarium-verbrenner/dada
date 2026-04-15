public class WhileLoopDemo {
    public static void main (String[] args) {
        String[] zahlen = {"eins", "zwei", "drei", "vier", "fünf"};

        int i = zahlen.length - 1;

        while (i >= 0) {

            System.out.println(zahlen[i]);

            i--;
        }
    }
}
