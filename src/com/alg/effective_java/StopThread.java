package com.alg.effective_java;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static volatile boolean stopREquested;

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            int i = 0;
            while (!stopREquested) {
                i++;
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        stopREquested = true;
    }
}
