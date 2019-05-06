package com.alg.Tests;

import java.util.Scanner;

public class Kuaishou3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(",");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        System.out.println(getInfo(a, b));
    }


    public static int getInfo(int a, int b) {

        if (a == b) return 0;
        if (a > b) return a - b;
        int count = 0;
        int flag = 0;
        while (a < b) {
            if (b % 2 == 0) {
                b /= 2;
                count++;
                flag = 1;
            } else {
                b += 1;
                b /= 2;
                count += 2;
                flag = 2;
            }
        }
        count += a - b;
        int count2 = 10000000;
        if (flag == 1) {
            count2 = count - (a - b) - 1 + (2 * b - a);
        } else {
            count2 = count - (a - b) - 2 + (2 * b - 1 - a);
        }
        return Math.min(count, count2);
    }

}
