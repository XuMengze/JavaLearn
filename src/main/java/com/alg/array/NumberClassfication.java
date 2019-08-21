package com.alg.array;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NumberClassfication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        int[] nums = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            nums[i] = sc.nextInt();
        }

        int A1 = 0;
        boolean A1True = false;
        int A2 = 0;
        boolean A2True = false;
        boolean minus = true;
        int A3 = 0;
        boolean A3True = false;
        int A4Sum = 0;
        int A4Count = 0;
        boolean A4True = false;
        int A5 = Integer.MIN_VALUE;
        boolean A5True = false;

        for (Integer num : nums) {
            int digit = num % 10;
            switch (digit) {
                case 0:
                    A1True = true;
                    A1 += num;
                    break;
                case 1:
                case 6:
                    A2True = true;
                    if (minus) {
                        A2 += num;
                        minus = false;
                    } else {
                        A2 -= num;
                        minus = true;
                    }
                    break;
                case 2:
                case 7:
                    A3True = true;
                    A3++;
                    break;
                case 3:
                case 8:
                    A4True = true;
                    A4Sum += num;
                    A4Count++;
                    break;
                case 4:
                case 9:
                    A5True = true;
                    if (A5 < num)
                        A5 = num;

                    break;
                default:
            }
        }
        System.out.println((A1True ? A1 : "N") + " " + (A2True ? A2 : "N") + " " + (A3True ? A3 : "N") + " " + (A4True ? new DecimalFormat("#.0").format(A4Sum / Double.parseDouble(A4Count + "")) : "N") + " " + (A5True ? A5 : "N"));
    }
}
