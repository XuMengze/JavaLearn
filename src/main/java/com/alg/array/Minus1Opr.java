package com.alg.array;

import java.util.Arrays;
import java.util.Scanner;

public class Minus1Opr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        int oprCount = sc.nextInt();
        int[] numArr = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            numArr[i] = sc.nextInt();
        }
        int[] oprArr = new int[oprCount];
        for (int i = 0; i < oprCount; i++) {
            oprArr[i] = sc.nextInt();
        }

        Arrays.sort(numArr);
        for (int i = 0, len = oprArr.length; i < len; i++) {
            int pos = bsearchfirst(numArr, oprArr[i]);
            if (pos == -1) {
                System.out.println(0);
            } else {
                System.out.println(numCount - pos);
            }
            inc(numArr, pos);
        }


    }

    static void inc(int[] arr, int pos) {
        for (int i = pos; i < arr.length && i >= 0; i++) {
            arr[i]--;
        }
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
        if (start >= arr.length) return -1;
        return arr[start] == target ? start : -1;
    }
}
