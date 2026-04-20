#include <stdio.h>
#include "operations.h"

int main() {
    int x = 10, y = 5;
    
    printf("Addition: %d + %d = %d\n", x, y, add(x, y));
    printf("Subtraktion: %d - %d = %d\n", x, y, subtract(x, y));
    printf("Multiplikation: %d * %d = %d\n", x, y, multiply(x, y));
    printf("Division: %d / %d = %.2f\n", x, y, divide(x, y));
    
    return 0;
}
