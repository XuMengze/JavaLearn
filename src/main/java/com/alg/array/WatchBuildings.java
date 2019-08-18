package com.alg.array;

import java.util.Scanner;

public class WatchBuildings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;
        count = sc.nextInt();
        int[] buildings = new int[count];
        for (int i = 0; i < count; i++) {
            buildings[i] = sc.nextInt();
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = 1 + getLeft(buildings, i) + getRight(buildings, i);
        }
        System.out.println(getRes(res));
    }

    static int getLeft(int[] arr, int index) {
        if (index == 0) {
            return 0;
        } else {
            int res = 1;
            int start = index - 1;
            int height = arr[start];
            for (int i = start - 1; i >= 0; i--) {
                if (arr[i] > height) {
                    res++;
                    height = arr[i];
                }
            }
            return res;
        }
    }

    static int getRight(int[] arr, int index) {
        if (index == arr.length - 1) {
            return 0;
        } else {
            int res = 1;
            int start = index + 1;
            int height = arr[start];
            for (int i = start + 1; i <= arr.length - 1; i++) {
                if (arr[i] > height) {
                    res++;
                    height = arr[i];
                }
            }
            return res;
        }
    }

    static String getRes(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : arr) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}