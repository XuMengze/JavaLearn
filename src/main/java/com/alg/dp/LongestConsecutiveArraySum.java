package com.alg.dp;


import java.util.Scanner;

public class LongestConsecutiveArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfReport = sc.nextInt();
        int threshold = sc.nextInt();
        int[] report = new int[numOfReport];
        for (int i = 0; i < numOfReport; i++) {
            report[i] = sc.nextInt();
        }
        System.out.println(getRes(report, threshold));
    }

    static int getRes(int[] arr, int k) {
        int[] h = new int[arr.length + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            h[i + 1] = Math.max(sum, h[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            pre = getLessIndex(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    static int getLessIndex(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= num) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
