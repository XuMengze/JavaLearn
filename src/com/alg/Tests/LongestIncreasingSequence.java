package com.alg.Tests;

import java.util.Arrays;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int[] initialSeq = {1, -1, 2, -3, 4, -5, 6, -7};
        int[] reslen = new int[initialSeq.length];
        for (int i = 0; i < reslen.length; i++) {
            reslen[i] = 1;
        }
        reslen[0] = 1;
        for (int i = 1; i < initialSeq.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (initialSeq[i] > initialSeq[j]) {
                    reslen[i] = Math.max(reslen[j] + 1, reslen[i]);
                }
            }
        }
        System.out.println(Arrays.stream(reslen).max().getAsInt());
    }
}
