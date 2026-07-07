#include "motion.h"
#include <stdio.h>

Distance calculate_mru_distance(Speed v, Time t, Time t0) {
    return v * (t - t0);
}

Distance calculate_mrua_distance(Speed v, Speed v0, Acceleration a) {
    if (a == 0.0) {
        printf("Fehler: Die Beschleunigung darf bei dieser Formel nicht null sein.\n");
        return 0.0;
    }
    return ((v * v) - (v0 * v0)) / (2.0 * a);
}

Speed calculate_mrua_speed(Acceleration a, Time t, Time t0, Speed v0) {
    return a * (t - t0) + v0;
}