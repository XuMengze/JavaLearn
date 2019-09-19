package com.alg.other;

import java.util.Scanner;

public class Integrations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] lower = new int[cnt];
        int[] upper = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            lower[i] = sc.nextInt();
            upper[i] = sc.nextInt();
        }
        for (int j = 0; j < cnt; j++) {
            double res = 0;
            for (double i = lower[j]; i < upper[j]; i += 0.01) {
                if (i < 0) {
                    res += f1(i + 0.005) * 0.01;
                } else if (i <= 2) {
                    res += f2(i + 0.005) * 0.01;
                } else if (i <= 5) {
                    res += f3(i + 0.005) * 0.01;
                } else if (i <= 10) {
                    res += f4(i + 0.005) * 0.01;
                } else {
                    res += f5(i + 0.005) * 0.01;
                }
            }
            System.out.println(Math.round(res));
        }
    }

    public static double f1(double x) {
        return 0;
    }

    public static double f2(double x) {
        return (2 - x) * Math.pow(x, 0.5);
    }

    public static double f3(double x) {
        return Math.pow(x, 3) - 2 * Math.pow(x, 2) - x + 2;
    }

    public static double f4(double x) {
        return 72 - Math.pow((x - 5) * Math.pow((x - 5) * Math.pow(x - 0.5, 0.5), 0.5), 0.5);
    }

    public static double f5(double x) {
        return 10;
    }
}