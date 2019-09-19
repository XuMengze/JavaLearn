package com.alg.java_core;

public class ExcepTest {
    public static void main(String[] args) {
        int s = testExcep();
        System.out.println(s);
    }

    static int testExcep() {
        try {
            int s = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("HHHHHH");
            return 1;
        } finally {
            System.out.println("HHHHHH2");
            return 2;
        }
    }
}
