package com.alg.other;

import java.util.Arrays;

public class Row1Row2 {
    public static void main(String[] args) {
        int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] B = getRow(A);
        System.out.println(Arrays.toString(B));
    }

    static int[] getRow(int[] A) {
        int[] res = new int[A.length];
        System.arraycopy(A, 0, res, 0, A.length);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < A.length; i++) {
                if (res[i] == getCount(res, A[i])) {
                    continue;
                } else {
                    res[i] = getCount(res, A[i]);
                    flag = true;
                }
            }
        }
        return res;
    }

    static int getCount(int[] A, int target) {
        return Integer.parseInt(Arrays.stream(A).filter(tar -> tar == target).count() + "");
    }
}
