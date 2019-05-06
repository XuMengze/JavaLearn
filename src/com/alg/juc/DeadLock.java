package com.alg.juc;

import java.util.concurrent.TimeUnit;

public class DeadLock {
    public static final String lock1 = "Lock1";
    public static final String lock2 = "Lock2";

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thd1());
        Thread thread2 = new Thread(new Thd2());
        thread1.start();
        thread2.start();
    }
}

class Thd1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Thd1 Running");
        synchronized (DeadLock.lock1) {
            System.out.println("Thd1 got lock1");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Into Catch");
            }
            synchronized (DeadLock.lock2) {
                System.out.println("Thd1 got lock2");
            }
        }
    }
}

class Thd2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Thd2 Running");
        synchronized (DeadLock.lock2) {
            System.out.println("Thd2 got lock2");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println("Into Catch");
            }
            synchronized (DeadLock.lock1) {
                System.out.println("Thd2 got lock1");
            }
        }
    }
}