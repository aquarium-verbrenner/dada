#ifndef MOTION_H
#define MOTION_H

#include "physics_types.h"

// Distance : s = v * (t - t0)
Distance calculate_mru_distance(Speed v, Time t, Time t0);

// Distance: s = (v² - v0²) / (2a)
Distance calculate_mrua_distance(Speed v, Speed v0, Acceleration a);

// Speed : v = a * (t - t0) + v0
Speed calculate_mrua_speed(Acceleration a, Time t, Time t0, Speed v0);

#endif