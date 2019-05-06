package com.alg.Tests;

import java.util.*;

public class ScannerDemo {
    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();

        int[] arr = new int[a];
        int[] arr2 = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));

    }
}
