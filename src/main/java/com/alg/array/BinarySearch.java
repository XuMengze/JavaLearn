package com.alg.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {3, 32, 321, 911};
        System.out.println(search(A, 911));
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
}
