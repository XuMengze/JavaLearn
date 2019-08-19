package com.alg.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WatchFlowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lookCnt = sc.nextInt();
        int flowerCnt = sc.nextInt();
        int[] watch = new int[lookCnt];
        for (int i = 0; i < lookCnt; i++) {
            watch[i] = sc.nextInt();
        }
        int conditionCnt = sc.nextInt();
        int[] left = new int[conditionCnt];
        int[] right = new int[conditionCnt];

        for (int i = 0; i < conditionCnt; i++) {
            left[i] = sc.nextInt();
            right[i] = sc.nextInt();
        }

        for (int i = 0; i < conditionCnt; i++) {
            Map<Integer, Boolean> res = new HashMap<>();
            for (int j = left[i] - 1; j <= right[i] - 1; j++) {
                res.put(watch[j], Boolean.TRUE);
            }
            System.out.println(res.size());
        }

    }
}
