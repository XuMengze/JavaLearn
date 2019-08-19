package com.alg.Tests;

import java.util.*;

public class ByteDancecccc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuffer[] s = new StringBuffer[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            s[i] = new StringBuffer(scanner.nextLine());
        }
        for (int i = 0; i < n; i++) {
            revise(s[i]);
        }

    }

    private static void revise(StringBuffer s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.size() == 0) {
                list.add(s.charAt(i));
            } else if (list.size() == 1) {
                if (list.get(0) != s.charAt(i)) {
                    list.clear();
                    list.add(s.charAt(i));
                } else {
                    list.add(s.charAt(i));
                }
            } else if (list.size() == 2) {
                if (list.get(1) == s.charAt(i)) {
                    s.deleteCharAt(i--);
                } else {
                    list.add(s.charAt(i));
                }
            } else if (list.size() == 3) {
                if (list.get(2) == s.charAt(i)) {
                    s.deleteCharAt(i--);
                } else {
                    list.clear();
                    list.add(s.charAt(i));
                }
            }
        }
        System.out.println(s);
    }
}

