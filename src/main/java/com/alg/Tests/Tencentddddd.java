package com.alg.Tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tencentddddd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }


    }

    public static int Solution(int[] a, int n, int m) {
        int minLen = n;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0, j = 0; i < a.length && j < a.length; j++) {
            if (!map.containsKey(a[j])) {
                map.put(a[j], 1);
            } else {
                if (a[j] != a[i]) {
                    map.put(a[j], map.get(a[j]) + 1);
                } else {
                    i++;
                    while (map.get(a[i]) > 1) {
                        map.put(a[i], map.get(a[i]) - 1);
                        if (map.get(a[i]) == 0) {
                            map.remove(a[i]);
                        }
                        i++;
                    }
                }
            }
            if (map.size() == m) {
                minLen = Math.min(minLen, j - i + 1);
            }
        }
        return minLen;

    }

}

