package com.alg.effective_java;

public interface Opera {
    default double apply(double x, double y) {
        return x;
    }
}
