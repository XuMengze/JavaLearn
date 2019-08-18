package com.alg.array;

import java.util.Arrays;
import java.util.Scanner;

public class ReversePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length;
        length = sc.nextInt();
        length = (int) Math.round(Math.pow(2, length));

        int[] initialArr = new int[length];
        for (int i = 0; i < length; i++) {
            initialArr[i] = sc.nextInt();
        }

        int reverseArr = sc.nextInt();
        int[] reverse = new int[reverseArr];
        for (int i = 0; i < reverseArr; i++) {
            reverse[i] = sc.nextInt();
        }

        for (int i = 0; i < reverseArr; i++) {
            rev(initialArr, (int) Math.round(Math.pow(2, reverse[i])));
            System.out.println(Arrays.toString(initialArr));
            System.out.println(getCount(initialArr, 0, initialArr.length - 1));
        }

    }

    static void rev(int[] arr, int k) {
        if (k == 1) {
            return;
        }

        for (int i = 0, len = arr.length; i <= len - k; i += k) {
            int start = i;
            int end = i + k - 1;
            while (start <= end) {
                arr[start] = arr[start] ^ arr[end];
                arr[end] = arr[start] ^ arr[end];
                arr[start] = arr[start] ^ arr[end];
                start++;
                end--;
            }
        }
    }

    static int getCount(int[] array, int start, int end) {
        array = array.clone();
        if (start >= end)
            return 0;
        int mid = (end + start) >> 1;
        int left = getCount(array, start, mid);
        int right = getCount(array, mid + 1, end);


        int count = 0;
        int i = mid;
        int j = end;
        int[] temp = new int[end - start + 1];
        int k = end - start;
        while (i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                count += (j - mid);
                temp[k--] = array[i--];
            } else {
                temp[k--] = array[j--];
            }
        }
        while (i >= start)
            temp[k--] = array[i--];
        while (j >= mid + 1)
            temp[k--] = array[j--];
        for (k = 0; k < temp.length; k++)
            array[k + start] = temp[k];

        return count + left + right;
    }
}
