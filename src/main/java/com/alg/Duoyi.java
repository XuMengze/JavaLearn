package com.alg;

import java.util.ArrayList;
import java.util.List;

public class Duoyi {
    public static void main(String[] args) {
//        for (int i = 10000; i < 99999; i++) {
//            if (Integer.parseInt((i + "").substring(0, 1)) % 3 == 0 && Integer.parseInt((i + "").substring(0, 2)) % 5 == 0 && Integer.parseInt((i + "").substring(0, 3)) % 7 == 0 && Integer.parseInt((i + "").substring(0, 4)) % 6 == 0 && Integer.parseInt((i + "").substring(0, 5)) % 14 == 0) {
//                System.out.println(i);
//            }
//        }

//        for (int i = 100; i < 999; i++) {
//            if (new StringBuilder(i * 67 + "").reverse().toString().startsWith("999")) {
//                System.out.println(i);
//            }
//        }
//        f(10);

        System.out.println(isDream(21));
    }


    public static int f(int x) {
        System.out.println("hhh");
        if (x <= 2) {
            return 1;
        } else {
            return f(x - 2) + f(x - 4) + 1;
        }
    }

    public static boolean isDream(int num) {
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(num);
        while (getSqareSum(num) != 1 && !tmpList.contains(getSqareSum(num))) {
            if (tmpList.contains(getSqareSum(num))) {
                return false;
            }
            num = getSqareSum(num);
            tmpList.add(num);
        }
        if (getSqareSum(num) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int getSqareSum(int n) {
        String[] s = (n + "").split("");
        int sum = 0;
        for (String singleNum : s) {
            sum += Math.pow(Integer.parseInt(singleNum), 2);
        }
        return sum;
    }
}
