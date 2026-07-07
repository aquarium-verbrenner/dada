#include <stdio.h>
#include "mechanics.h"
#include "motion.h"

void menu() {
    printf("--- TEST MENU ---\n");
    printf("1. Eine Geschwindigkeit berechnen (v = ds/dt)\n");
    printf("2. Eine Beschleunigung berechnen (a = dv/dt)\n");
    printf("3. Einen Impuls berechnen (p = m*v)\n");
    printf("4. Distanz (s = v*(t-t0))\n");
    printf("5. Distanz (s = (v²-v0²)/2a)\n");
    printf("6. Geschwindigkeit (v = a*(t-t0)+v0)\n");
    printf("Auswahl : ");
}

int main() {
    int choice = -1;
    
    while (choice != 0) {
        menu();
        if (scanf("%d", &choice) != 1) {
            printf("Ungültige Eingabe.\n");
            break;
        }

        switch (choice) {
            case 1: {
                Distance ds; Time dt;
                printf("Geben Sie delta_s (m) und delta_t (s) ein : ");
                scanf("%lf %lf", &ds, &dt);
                printf("Ergebnis : v = %.2f m/s\n", calculate_speed(ds, dt));
                break;
            }
            case 2: {
                Speed dv; Time dt;
                printf("Geben Sie delta_v (m/s) und delta_t (s) ein : ");
                scanf("%lf %lf", &dv, &dt);
                printf("Ergebnis : a = %.2f m/s²\n", calculate_acceleration(dv, dt));
                break;
            }
            case 3: {
                Mass m; Speed v;
                printf("Geben Sie die Masse (kg) und die Geschwindigkeit (m/s) ein : ");
                scanf("%lf %lf", &m, &v);
                printf("Ergebnis : p = %.2f kg*m/s\n", calculate_momentum(m, v));
                break;
            }
            case 4: {
                Speed v; Time t, t0;
                printf("Geben Sie v (m/s), t (s) und t0 (s) ein : ");
                scanf("%lf %lf %lf", &v, &t, &t0);
                printf("Ergebnis : s = %.2f m\n", calculate_mru_distance(v, t, t0));
                break;
            }
            case 5: {
                Speed v, v0; Acceleration a;
                printf("Geben Sie v (m/s), v0 (m/s) und a (m/s²) ein : ");
                scanf("%lf %lf %lf", &v, &v0, &a);
                printf("Ergebnis : s = %.2f m\n", calculate_mrua_distance(v, v0, a));
                break;
            }
            case 6: {
                Acceleration a; Time t, t0; Speed v0;
                printf("Geben Sie a (m/s²), t (s), t0 (s) und v0 (m/s) ein : ");
                scanf("%lf %lf %lf %lf", &a, &t, &t0, &v0);
                printf("Ergebnis : v = %.2f m/s\n", calculate_mrua_speed(a, t, t0, v0));
                break;
            }
            default:
                printf("Ungültige Auswahl, versuchen Sie es erneut.\n");
        }
    }
    return 0;
}