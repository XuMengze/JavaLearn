package com.alg.Tests;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AliBaba {

    public static void main(String[] args) {
//        calculate(10, 20);
//        System.out.println(calculate(20, 3));
        System.out.println(getRankYear(4));
    }

    static String calculate(int m, int k) {
        int[] num = generatrNum(m);
        String res = "";
        res = res + num[m - 1] + ",";
        res = res + (int) (2019 + getRankYear(m)) + ",";
        res = res + getRankNum(num, k);
        return res;
    }

    static int[] generatrNum(int m) {
        int[] num = new int[m + 3];
        num[0] = 2;
        num[1] = 3;
        num[2] = 4;
        for (int i = 3; i < m + 1; i++) {
            num[i] = num[i - 2] + num[i - 3];
        }
        return Arrays.copyOfRange(num, 0, m);
    }

    static int getRankYear(int m) {
        int[] fib = new int[100];
        fib[0] = 1;
        fib[1] = 2;
        for (int i = 2; i < 100; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        if (m != 0 && m - 2 <= 0) {
            return 1;
        } else {
            m -= 2;
        }
        if (m != 0 && m - 1 <= 0) {
            return 1;
        } else {
            m -= 1;
        }
        int index = 2;
        int start = 1;
        while (m > 0) {
            index++;
            m -= start;
            start *= fib[index - 1];
        }
        return index;
    }

    static int getRankNum(int[] m, int k) {

        int[] s = m.clone();
        for (int i = 0; i < s.length; i++) {
            s[i] = Integer.parseInt(new StringBuilder(s[i] + "").reverse().toString());
        }
        Arrays.sort(s);
        int target = s[s.length - k];

        int original = Integer.parseInt(new StringBuilder(target + "").reverse().toString());

        for (int i = 0; i < m.length; i++) {
            if (m[i] == original) {
                return i + 1;
            }
        }
        return 0;
    }


}
