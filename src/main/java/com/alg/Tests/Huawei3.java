package com.alg.Tests;

import java.util.*;

public class Huawei3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] boil = new int[m];
            for (int j = 0; j < m; j++) {
                boil[j] = sc.nextInt();
            }
            res.add(getTime(n, boil, x, y));
            for (Integer inte : res) {
                System.out.println(inte);
            }
        }

    }

    public static int getTime(int n, int[] boil, int x, int y) {
        Arrays.sort(boil);
        if (n == 1) {
            return boil[0] + Math.min(x, y);
        } else if (n == 2) {
            return Math.min(boil[1], 2 * boil[0]) + Math.min(x, y);
        } else {
            return 100;
        }
    }
}
