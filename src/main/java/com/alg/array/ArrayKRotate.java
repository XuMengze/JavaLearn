package com.alg.array;


import java.util.Arrays;

public class ArrayKRotate {
    public static void main(String[] args) {
        int[] ori = {
                1, 2, 3, 4, 5
        };
        System.out.println(Arrays.toString(movek(ori, 2)));
    }

    public static int[] movek(int[] originalArr, int k) {
        k = k % originalArr.length;
        int start = originalArr.length - k;
        int[] resArr = new int[originalArr.length];
        System.arraycopy(originalArr, start, resArr, 0, k);
        System.arraycopy(originalArr, 0, resArr, k, originalArr.length - k);
        return resArr;
    }
}
