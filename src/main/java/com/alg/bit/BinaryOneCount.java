package com.alg.bit;

import java.util.*;

public class BinaryOneCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int sample = sc.nextInt();
        for (int i = 0; i < sample; i++) {
            int numberCount = sc.nextInt();
            int[] num = new int[numberCount];
            for (int j = 0; j < numberCount; j++) {
                num[j] = sc.nextInt();
            }
            Map<Integer, Integer> tmpRes = new HashMap<>();
            for (Integer integer :
                    num) {
                tmpRes.put(oneNum(integer), 0);
            }
            res.add(tmpRes.size());
        }
        for (Integer i : res
        ) {
            System.out.println(i);
        }
    }

    public static int oneNum(int s) {
        int num = 0;
        while (s != 0) {
            num += s & 1;
            s >>>= 1;
        }
        return num;
    }
}
