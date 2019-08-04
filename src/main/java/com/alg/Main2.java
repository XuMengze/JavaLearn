package com.alg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        String[] nums = new String[numCount];
        for (int i = 0; i < numCount; i++) {
            nums[i] = sc.nextInt() + "";
        }
        boolean hasEven = false;
        boolean hasOdd = false;
        for (String num : nums
        ) {
            if (Integer.parseInt(num) % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
            if (hasEven == hasOdd) {
                break;
            }
        }
        if (hasEven != hasOdd) {
            System.out.println(arr2Str(nums));
            return;
        }
        Arrays.sort(nums, new MyComparator());
        System.out.println(arr2Str(nums));
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (Integer.parseInt(a) + Integer.parseInt(b) % 2 == 0) {
                return 0;
            }
            return a.compareTo(b);
        }
    }

    public static String arr2Str(String[] num) {
        StringBuilder sb = new StringBuilder();
        for (String i : num
        ) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
