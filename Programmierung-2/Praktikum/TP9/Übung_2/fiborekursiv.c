#include <stdio.h>
#include <time.h>

long long fibonacciRecursive(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
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

    printf("Berechne rekursiv...\n");
    start = clock();
    long long res_recur = fibonacciRecursive(n);
    end = clock();
    time_used = ((double) (end - start)) / CLOCKS_PER_SEC * 1000.0;
    printf("Rekursiv: Fib(%d) = %lld (Zeit: %.4f ms)\n", n, res_recur, time_used);

    return 0;
}