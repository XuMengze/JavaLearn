package com.alg.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {0, 0, 1, 1, 1, 1, 2, 2, 2};
        System.out.println(bsearchlast(A, 1));
    }

    static int search(int[] arr, int target) {
        return bsearch(arr, 0, arr.length, target);
    }

    static int bsearch(int[] arr, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return bsearch(arr, low, mid - 1, target);
        } else {
            return bsearch(arr, mid + 1, high, target);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    static int bsearchfirst(int[] arr, int target) {
        int start = 0, end = arr.length, mid;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start] == target ? start : -1;
    }

    static int bsearchlast(int[] arr, int target) {
        int start = 0, end = arr.length;
        int mid;
        while (start < end) {
            mid = start + (int) ((end - start) / 2.0 + 0.5);
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return arr[end] == target ? end : -1;
    }
}
