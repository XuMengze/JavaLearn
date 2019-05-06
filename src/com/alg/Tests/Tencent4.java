package com.alg.Tests;

import java.util.*;

public class Tencent4 {

    public static void main(String[] args) {
        int times, colors;
        Scanner sc = new Scanner(System.in);
        times = sc.nextInt();
        colors = sc.nextInt();

        int[] shot = new int[times];

        for (int i = 0; i < times; i++) {
            shot[i] = sc.nextInt();
        }

        System.out.println(Solution(shot, times, colors));
    }

    public static int Solution(int[] shot, int times, int colors) {
        int minLen = times;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0, j = 0; i < shot.length && j < shot.length; j++) {
            if (!map.containsKey(shot[j])) {
                map.put(shot[j], 1);
            } else {
                if (shot[j] != shot[i]) {
                    map.put(shot[j], map.get(shot[j]) + 1);
                } else {
                    i++;
                    while (map.get(shot[i]) > 1) {
                        map.put(shot[i], map.get(shot[i]) - 1);
                        if (map.get(shot[i]) == 0) {
                            map.remove(shot[i]);
                        }
                        i++;
                    }
                }
            }
            if (map.size() == colors) {
                minLen = Math.min(minLen, j - i + 1);
            }
        }
        return minLen;

    }
}
