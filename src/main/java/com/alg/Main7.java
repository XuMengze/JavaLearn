package com.alg;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String mess = sc.nextLine();
        int out = sc.nextInt();
        sc.nextLine();
        String[] tests = new String[out];
        int res = 0;
        for (int i = 0; i < out; i++) {
            tests[i] = sc.nextLine();
        }

        for (String s : tests) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0, times = len / s.length() + 1; i < times; i++) {
                sb.append(s);
            }
            if (sb.substring(0, len).equals(mess)) {
                res++;
            }
        }
        System.out.println(res);
    }
}
