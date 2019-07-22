package com.alg.array;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {
                2, 4, 1, 2, 5, 8, 1, 2
        };
        quick(arr, 0, arr.length);
    }

    static void quick(int[] arr, int i, int j) {
        int mid = partition(arr, i, j);
        quick(arr, i, mid);
        quick(arr, mid + 1, j);
    }

    static int partition(int[] arr, int i, int j) {
        int tmp = i;
        while (i < j) {
            while (arr[++i] < arr[tmp]) ;
            while (arr[j++] > arr[tmp]) ;
            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, tmp, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
