package com.alg.Tests;

import java.util.Arrays;
import java.util.Scanner;

public class ByteDance2 {

    public static void main(String[] args) {
        int strNum;
        Scanner sc = new Scanner(System.in);
        strNum = sc.nextInt();
        String[] strArr = new String[strNum];
        for (int i = 0; i < strNum; i++) {
            strArr[i] = sc.next();
        }
        for (int i = 0; i < strNum; i++) {
            System.out.println(method(strArr[i]));
        }
    }

    private static String method(String s) {
        String res = solution(s);
        while (!(res.length() == s.length())) {
            s = res;
            res = solution(s);
        }
        return res;
    }

    private static String solution(String s) {

        char[] ca = s.toCharArray();
        int len = ca.length;
        if (s.length() >= 3) {
            for (int i = 0; i <= len - 3; i++) {
                if (ca[i] == ca[i + 1] && ca[i + 1] == ca[i + 2]) {
                    ca[i + 2] = ' ';
                }
            }
        }
        if (s.length() >= 4) {
            for (int i = 0; i <= len - 4; i++) {
                if (ca[i] == ca[i + 1] && ca[i + 2] == ca[i + 3]) {
                    ca[i + 2] = ' ';
                }
            }
        }
        String res = "";
        for (char c : ca) {
            if (c != ' ') {
                res += c;
            }
        }
        return res;
    }
}
