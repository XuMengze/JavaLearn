package com.alg.array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(mergeSortedArr(a, b)));
    }

    public static int[] mergeSortedArr(int[] a, int[] b) {
        int[] resArr = new int[a.length + b.length];
        int aIndex = 0, bIndex = 0;
        int resIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] < b[bIndex]) {
                resArr[resIndex] = a[aIndex];
                aIndex++;
                resIndex++;
            } else if (a[aIndex] > b[bIndex]) {
                resArr[resIndex] = b[bIndex];
                bIndex++;
                resIndex++;
            } else {
                resArr[resIndex] = a[aIndex];
                resArr[resIndex + 1] = b[bIndex];
                aIndex++;
                bIndex++;
                resIndex += 2;
            }
        }
        if (aIndex < a.length) {
            System.arraycopy(a, aIndex, resArr, resIndex, a.length - aIndex);
        }
        if (bIndex < b.length) {
            System.arraycopy(b, bIndex, resArr, resIndex + a.length - aIndex, b.length - aIndex);
        }
        return resArr;
    }
}
