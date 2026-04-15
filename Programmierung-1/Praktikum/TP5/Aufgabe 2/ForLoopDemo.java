public class ForLoopDemo {
    public static void main (String[] args) {
        String[] zahlen = {"eins", "zwei", "drei", "vier", "fünf"};
        
        for (int i = zahlen.length - 1; i >= 0; i--) {
            System.out.println(zahlen[i]);
        }
    }
}
