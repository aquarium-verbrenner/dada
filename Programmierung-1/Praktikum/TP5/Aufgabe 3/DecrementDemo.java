public class DecrementDemo {

    public static void main(String[] args) {

        System.out.println("For loop :");
        
        for (int i = 0; i >= -5; i--) {
            System.out.println(i);
        }

        System.out.println("While loop :");

        int j = 0;
        while (j >= -5) {
            System.out.println(j);
            j--;
        }
    }
}