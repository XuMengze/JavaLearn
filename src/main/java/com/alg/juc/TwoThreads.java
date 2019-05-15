package com.alg.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreads {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            exec.execute(() -> {
                A a = new A();
                System.out.println(System.identityHashCode(A.class));
            });
        }
        exec.shutdown();
    }
}

class A {
    String a = "sss";

}
