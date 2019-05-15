package com.alg.array;

import java.util.Arrays;

public class CombineNumbers {
    public static void main(String[] args) {
        int[] A = {3,32,321,9};
        quickSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    static void quickSort(int[] A, int i, int j) {
        if (i < j) {
            int mid = diyPartition(A, i, j);
            quickSort(A, i, mid - 1);
            quickSort(A, mid + 1, j);
        }
    }

    static boolean smaller(int a, int b) {
        String aa = a + "" + b;
        String bb = b + "" + a;
        if (aa.compareTo(bb) < 0) {
            return true;
        } else
            return false;
    }

    static int partition(int[] A, int left, int right) {
        if (left >= right)
            return left;
        int start = left;
        while (left < right) {
            while (left <= right && A[start] >= A[left]) {
                left++;
            }
            while (left <= right && A[start] <= A[right]) {
                right--;
            }
            if (left < right) {
                swap(A, left, right);
            }
        }
        swap(A, start, right);
        return right;
    }

    static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    static int diyPartition(int[] A, int left, int right) {
        if (left >= right)
            return left;
        int start = left;
        while (left < right) {
            while (left <= right && smaller(A[left], A[start])) {
                left++;
            }
            while (left <= right && smaller(A[start], A[right])) {
                right--;
            }
            if (left < right) {
                swap(A, left, right);
            }
        }
        swap(A, start, right);
        return right;
    }
}
