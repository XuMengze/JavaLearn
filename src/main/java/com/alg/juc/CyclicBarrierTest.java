package com.alg.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public static final int SIZE = 10;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch cdLatch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            exec.execute(new Task(cdLatch));
        }
        cdLatch.await();
        System.out.println("HHHHHHHHH");
        exec.shutdown();
    }
}

class Task implements Runnable {
    private final CountDownLatch latch;

    public Task(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Run Run Run!");
        latch.countDown();
    }
}