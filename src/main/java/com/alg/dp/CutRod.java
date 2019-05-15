package com.alg.dp;

import java.util.Arrays;

public class CutRod {
    public static final int LEN = 10;

    public static void main(String[] args) {
        cut(p, LEN);
    }

    static int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    static void cut(int[] p, int LEN) {
        int[] r = new int[LEN+1];
        int[] s = new int[LEN+1];
        r[0] = 0; s[0] = 0;
        for (int i = 1; i <= LEN; i++) {
            int q = -1;
            for (int j = 1; j <= i; j++) {
                if (q < r[i - j] + p[j-1]) {
                    q = r[i - j] + p[j-1];
                    s[i] = j;
                    r[j] = q;
                }
            }
        }
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(r));

    }
}
