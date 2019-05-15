package com.alg.other;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] A) {
        if (A.length <= 0) {
            return 0;
        }
        int first = A[0];
        for (int i = 1; i < A.length; i++) {
            first ^= A[i];
        }
        return first;
    }

    public static int singleNumberII(int[] A) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            int bits = 0;
            for (int j = 0; j < A.length; ++j) {
                bits += (A[j] >> i) & 1;
            }
            result |= (bits % 3) << i;
        }
        return result;
    }
}
