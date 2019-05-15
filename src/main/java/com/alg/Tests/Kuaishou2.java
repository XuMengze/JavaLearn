package com.alg.Tests;

import java.util.Scanner;

public class Kuaishou2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        System.out.println(getNoneZero(10));

    }


    public static int getNoneZero(int n) {
        if (n == 0 || n == 1) {
            System.out.println(1);
            return 1;
        }
        int tmp = 1;
        for (int i = n; i > 0; i--) {
            if (i % 10 == 0) {
                i = i / 10;
                while (i % 10 == 0) {
                    i = i / 10;
                }
            }
            tmp = tmp * (i % 10);
            if (tmp % 10 == 0) {
                tmp = tmp / 10;
            }
            if (tmp > 10) {
                tmp = tmp % 10;
            }

        }
        return tmp;
    }
}