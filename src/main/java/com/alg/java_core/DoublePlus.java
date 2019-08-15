package com.alg.java_core;

public class DoublePlus {
    public static void main(String[] args) {
        int a = 0, b = 0;
        for (int i = 0; i < 100; i++) {
            a = a++; //哈哈哈哈哈 IDEA有注释这样写不好
        }
        for (int i = 0; i < 100; i++) {
            b = ++b;
        }
        System.out.println(a);
        System.out.println(b);
    }
}
