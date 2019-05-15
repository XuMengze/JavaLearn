package com.alg.juc;

public class F {
    public static void main(String[] args) {
        G c = new G();
        new Thread(() -> {
            G a = new G();
            c.method();
        }).start();
        new Thread(() -> {
            G b = new G();
            c.method();
        }).start();
    }
}

class G {
    public synchronized void method() {
        System.out.println("HHHHH");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

