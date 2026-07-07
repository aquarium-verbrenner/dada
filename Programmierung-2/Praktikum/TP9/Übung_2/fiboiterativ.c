#include <stdio.h>
#include <time.h>

unsigned long long fibonacciIterative(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    
    long long a = 0, b = 1, c;
    for (int i = 2; i <= n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}

int main() {
    int n;
    clock_t start, end;
    double time_used;

    printf("Geben Sie eine Zahl n ein: ");
    if (scanf("%d", &n) != 1) {
        printf("Fehler bei der Eingabe.\n");
        return 1;
    }

    start = clock();
    long long res_iter = fibonacciIterative(n);
    end = clock();
    time_used = ((double) (end - start)) / CLOCKS_PER_SEC * 1000.0;
    printf("Iterativ: Fib(%d) = %lld (Zeit: %.4f ms)\n", n, res_iter, time_used);

    return 0;
}