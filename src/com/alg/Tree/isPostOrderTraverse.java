package com.alg.Tree;

public class isPostOrderTraverse {
    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 9, 11, 10, 8};
        boolean res = isPost(arr, 0, arr.length - 1);
        System.out.println(res);
    }

    public static boolean isPost(int[] arr, int low, int high) {
        if (high - low <= 1) {
            return true;
        }
        int root = arr[high];
        int seperator = low;
        for (; seperator <= high - 1; seperator++) {
            if (arr[seperator] > root) {
                break;
            }
        }
        int split = seperator;
        for (; seperator <= high - 1; seperator++) {
            if (arr[seperator] < root) {
                return false;
            }
        }
        return isPost(arr, low, split - 1) && isPost(arr, split, high-1);
    }
}
