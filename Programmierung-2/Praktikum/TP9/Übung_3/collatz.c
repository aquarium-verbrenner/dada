#include <stdio.h>

int collatzSteps(int n) {
    int steps = 0;
    
    printf("Collatz-Folge: %d", n);
    
    while (n > 1) {
        if (n % 2 == 0) {
            n = n / 2;
        } else {
            n = 3 * n + 1;
        }
        printf(" %d", n);
        steps++;
    }
    printf("\n");
    return steps;
}

int main() {
    int start_zahl;

    printf("Geben Sie eine Zahl ein: ");
    if (scanf("%d", &start_zahl) != 1 || start_zahl <= 0) {
        printf("Bitte geben Sie eine positive Zahl ein.\n");
        return 1;
    }

    int total_steps = collatzSteps(start_zahl);
    printf("Anzahl der Schritte: %d\n", total_steps);

    return 0;
}