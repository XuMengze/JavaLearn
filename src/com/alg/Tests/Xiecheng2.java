package com.alg.Tests;

import java.util.Arrays;
import java.util.Scanner;

public class Xiecheng2 {

    public static void main(String[] args) {
        int reverseUnit;
        Scanner sc = new Scanner(System.in);
        String unReList = sc.nextLine();
        String[] strList = unReList.substring(1, unReList.length() - 1).split(",");
        reverseUnit = sc.nextInt();
        for (int i = 0; i < strList.length; i += reverseUnit) {
            if (i + reverseUnit - 1 < strList.length) {
                reverse(strList, i, i + reverseUnit - 1);
            }
        }
        System.out.println(Arrays.toString(strList).replace(" ",""));
    }

    public static void reverse(String[] arr, int i, int j) {
        while (i < j) {
            String tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

}
