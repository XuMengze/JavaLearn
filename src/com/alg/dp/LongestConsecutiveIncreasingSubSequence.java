package com.alg.dp;

import java.util.Arrays;

public class LongestConsecutiveIncreasingSubSequence {
    public static void main(String[] args) {
        System.out.println(getLCISS("abcd12345ed125ss123456789"));
    }

    public static int getLCISS(String s) {
        char[] ca = s.toCharArray();
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] lCISS = new int[s.length()];
        lCISS[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (ca[i] > ca[i - 1]) {
                lCISS[i] = lCISS[i - 1] + 1;
            } else {
                lCISS[i] = 1;
            }
        }
        return Arrays.stream(lCISS).max().getAsInt();
    }
}
