#include "mechanics.h"
#include <stdio.h>

Speed calculate_speed(Distance delta_s, Time delta_t) {
    if (delta_t == 0.0) {
        printf("Fehler: Division durch Null (Nullzeit).\n");
        return 0.0;
    }
    return delta_s / delta_t;
}

Acceleration calculate_acceleration(Speed delta_v, Time delta_t) {
    if (delta_t == 0.0) {
        printf("Fehler: Division durch Null (Nullzeit).\n");
        return 0.0;
    }
    return delta_v / delta_t;
}

Momentum calculate_momentum(Mass m, Speed v) {
    return m * v;
}