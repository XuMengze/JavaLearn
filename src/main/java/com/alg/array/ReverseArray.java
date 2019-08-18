package com.alg.array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] testArray = new int[]{1, 2, 3, 4, 5, 6};
        reverseArrayKGroupFalse(testArray,3);
        System.out.println(Arrays.toString(testArray));

    }

    public int minNumberInRotateArray(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }

    static void reverseArray(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int begin = 0, end = arr.length - 1;
        while (begin < end) {
            arr[begin] = arr[begin] ^ arr[end];
            arr[end] = arr[begin] ^ arr[end];
            arr[begin] = arr[begin] ^ arr[end];
            begin++;
            end--;
        }
    }

    static void reverseArrayKGroupTrue(int[] arr, int k) {
        if (arr.length <= 1 || k <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i += k) {
            int begin = i, end = Math.min(arr.length - 1, i + k - 1);
            while (begin < end) {
                arr[begin] = arr[begin] ^ arr[end];
                arr[end] = arr[begin] ^ arr[end];
                arr[begin] = arr[begin] ^ arr[end];
                begin++;
                end--;
            }
        }
    }

    static void reverseArrayKGroupFalse(int[] arr, int k) {
        for (int i = 0; i < arr.length; i += k) {
            int begin = i, end = i + k - 1;
            if (end > arr.length - 1) {
                break;
            }
            while (begin < end) {
                arr[begin] = arr[begin] ^ arr[end];
                arr[end] = arr[begin] ^ arr[end];
                arr[begin] = arr[begin] ^ arr[end];
                begin++;
                end--;
            }
        }
    }
}
