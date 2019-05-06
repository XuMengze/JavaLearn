package com.alg.Tests;

import java.util.Scanner;

public class Tencent2 {

    public static void main(String[] args) {
        int times;
        Scanner sc = new Scanner(System.in);
        times = sc.nextInt();

        int[] left = new int[times];
        int[] right = new int[times];

        for (int i = 0; i < times; i++) {
            left[i] = sc.nextInt();
            right[i] = sc.nextInt();
        }

    }
}
