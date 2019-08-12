package com.alg.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaterStorage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int sampleCount = sc.nextInt();
        for (int i = 0; i < sampleCount; i++) {
            int[] sample = new int[6];
            sample[0] = sc.nextInt();
            sample[1] = sc.nextInt();
            sample[2] = sc.nextInt();
            sample[3] = sc.nextInt();
            sample[4] = sc.nextInt();
            sample[5] = sc.nextInt();
            res.add(deal(sample));
        }
        for (Integer i : res
        ) {
            System.out.println(i);
        }
    }

    public static int deal(int[] inputArr) {
        int maxCapacity = inputArr[0], time = inputArr[1],
                m1 = inputArr[2], t1 = inputArr[3],
                m2 = inputArr[4], t2 = inputArr[5];

        int water = 0;
        for (int i = 0; i < time; i++) {
            boolean inPileOpen = (i / t1) % 2 == 0;
            boolean outPileOpen = (i / t2) % 2 == 0;
            if (inPileOpen == true && outPileOpen == true) {
                if (m1 > m2) {
                    water = Math.min(maxCapacity, water + (m1 - m2));
                } else {
                    water = Math.max(0, water - (m2 - m1));
                }
            } else if (inPileOpen == true) {
                water = Math.min(maxCapacity, water + m1);
            } else if (outPileOpen == true) {
                water = Math.max(0, water - m2);
            } else {

            }
        }
        return water;
    }
}
