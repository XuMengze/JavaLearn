package com.alg.java_core;

public class ExtendTest {
    public static void main(String[] args) {
        A haha = new B();
        System.out.println(((B)haha).a);
        System.out.println(haha.b);
        haha.bb();
        haha.cc();
    }
}


class A {
    static int a = 1;
    int b = 2;

    static void aa() {
        System.out.println("A : a");
    }

    void bb() {
        System.out.println("A : b");
    }

    void cc() {
        System.out.println("A : c");
    }
}

class B extends A {
    static int a = 3;
    int b = 4;

    static void aa() {
        System.out.println("B : a");
    }

    void bb() {
        System.out.println("B : b");
    }
}