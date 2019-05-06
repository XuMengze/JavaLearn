package com.alg.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TextThread {
    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO 自动生成方法存根
        TxtThread tt = new TxtThread();
//        new Thread(tt).start();
//        new Thread(tt).start();
//        new Thread(tt).start();
//        new Thread(tt).start();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            exec.execute(new Thread(tt));
        }
    }
}

class TxtThread implements Runnable {
    int num = 100;
    String str = new String();

    public void run() {
        while (true) {
            synchronized (str) {
                if (num > 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "this is " + num--);
                        str.wait(100);
                    } catch (Exception e) {
                        e.getMessage();
                    }

                }
            }
        }
    }
}