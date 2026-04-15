public class Crible {
    public static boolean[] findPrimesOptimized(int n) {
    boolean[] isPrime = new boolean[n + 1];
    for (int i = 2; i <= n; i++) isPrime[i] = true;

    for (int p = 2; p * p <= n; p++) {
        if (isPrime[p]) {
            
            for (int i = p * p; i <= n; i += p) {
                isPrime[i] = false;
            }
        }
    }
    return isPrime;
}
}
