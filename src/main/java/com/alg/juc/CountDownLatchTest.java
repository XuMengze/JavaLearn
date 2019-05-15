package com.alg.juc;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CountDownLatchTest {
    public static void main(String[] args) throws Exception {
//        int N = 4;
//        CyclicBarrier barrier = new CyclicBarrier(N);
//
//        for (int i = 0; i < N; i++) {
//            new Writer(barrier).start();
//        }
//
//        try {
//            Thread.sleep(25000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("CyclicBarrier重用");
//
//        for (int i = 0; i < N; i++) {
//            new Writer(barrier).start();
//        }

        CyclicBarrier sc = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("Summon!");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });
//        do {
//
//        } while (true);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println("Collecting");
                try {
                    sc.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");

                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "所有线程写入完毕，继续处理其他任务...");
        }
    }
}
