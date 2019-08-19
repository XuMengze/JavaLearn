package com.alg.Tests;

import java.util.Scanner;

public class ByteDance {

    public static void main(String[] args) {
        int money;
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();

        int res = 0;
        int zhaoqian = 1024 - money;

        res += zhaoqian / 64;
        zhaoqian = zhaoqian % 64;
        res += zhaoqian / 16;
        zhaoqian = zhaoqian % 16;
        res += zhaoqian / 4;
        zhaoqian = zhaoqian % 4;
        res += zhaoqian;

        System.out.println(res);

    }
}
