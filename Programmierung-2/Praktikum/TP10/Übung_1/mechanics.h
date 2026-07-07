#ifndef MECHANICS_H
#define MECHANICS_H

#include "physics_types.h"

// Speed : v = ds / dt
Speed calculate_speed(Distance delta_s, Time delta_t);

// Acceleration : a = dv / dt
Acceleration calculate_acceleration(Speed delta_v, Time delta_t);

// Momentum : p = m * v
Momentum calculate_momentum(Mass m, Speed v);

#endif