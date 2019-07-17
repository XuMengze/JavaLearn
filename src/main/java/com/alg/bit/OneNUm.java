package com.alg.bit;

import java.util.Arrays;

public class OneNUm {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countOne(7)));
    }

    public static int[] countOne(int m) {
        int[] resArr = new int[m + 1];
        if (m == 1) {
            resArr[0] = 0;
            return resArr;
        }
        if (m == 2) {
            resArr[0] = 0;
            resArr[1] = 1;
            return resArr;
        }
        resArr[0] = 0;
        resArr[1] = 1;
        int base = 2;
        for (int i = 2; i <= m; i++) {
            if (base * 2 > i) {
                resArr[i] = resArr[i % base] + 1;
            } else {
                base = base << 1;
                resArr[i] = resArr[i % base] + 1;
            }
        }
        return resArr;
    }
}
