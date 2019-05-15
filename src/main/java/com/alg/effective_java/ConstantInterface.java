package com.alg.effective_java;

public class ConstantInterface implements PhysicalConstants {
    public static void main(String[] args) {
        double s = PhysicalConstants.AVOGADROS_NUMBER * 12;
    }
}

interface PhysicalConstants {
    double AVOGADROS_NUMBER = 6.022_104_857e23;
}