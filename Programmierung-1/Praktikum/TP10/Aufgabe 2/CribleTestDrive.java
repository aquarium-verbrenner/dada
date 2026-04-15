public class CribleTestDrive {
    public static void main(String[] args) {
        int limit = 30;
        boolean[] primes = Crible.findPrimesOptimized(limit);

        System.out.println("Nombres premiers jusqu'à " + limit + " :");
        for (int i = 0; i <= limit; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
    
