package com.alg.array;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, -10, 4, 7, 2, 5};
        int maxSub = findMaxSubarray(A, 0, A.length - 1);
        System.out.println(maxSub);
    }

    public static int findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        int sum = 0;
        int leftSum = -10000;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (leftSum < sum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = -10000;
        for (int i = mid + 1; i <= high; i++) {
            sum += A[i];
            if (rightSum < sum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public static int findMaxSubarray(int[] A, int low, int high) {
        if (high == low) {
            return A[low];
        } else {
            int mid = (high + low) / 2;
            int leftSum = findMaxSubarray(A, low, mid);
            int crossSum = findMaxCrossingSubarray(A, low, mid, high);
            int rightSum = findMaxSubarray(A, mid + 1, high);

            return Math.max(crossSum, Math.max(rightSum, leftSum));
        }
    }
}
