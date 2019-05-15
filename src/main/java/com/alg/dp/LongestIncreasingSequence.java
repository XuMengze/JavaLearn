package com.alg.dp;

import java.util.Arrays;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        String s1 = "01s23s45s6s7";
        System.out.println(LIS(s1));
    }

    static int LIS(String str) {
        int[] LIS = new int[str.length()];
        Arrays.fill(LIS, 1);
        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(i) > str.charAt(j) && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }
        return LIS[str.length() - 1];
    }
}
