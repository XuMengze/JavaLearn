package com.alg.effective_java;

public enum Planet {
    MERCURY(3.302e23, 2.439e5),
    VENUS(4.869e24, 6.052e6),
    EARTH(5.975e24, 6.378e6);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private static final double G = 6.673_00e-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}
