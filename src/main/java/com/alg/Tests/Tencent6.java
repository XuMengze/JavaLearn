package com.alg.Tests;

import java.util.Scanner;

public class Tencent6 {

    public static void main(String[] args) {
        System.out.println(getSum(1, 100000000));
    }

    public static int getSum(int left, int right) {
        if (left == right) {
            if (right % 2 == 0) {
                return right;
            } else {
                return 0 - right;
            }
        }
        if ((right - left + 1) % 2 != 0) {
            if (right % 2 == 0) {
                return (-1) * ((right - left) / 2) + right;
            } else {
                return (1) * ((right - left) / 2) - right;
            }
        } else {
            if (left % 2 == 0) {
                return (-1) * ((right - left + 1) / 2);
            } else {
                return (1) * ((right - left + 1) / 2);
            }
        }
    }
}
