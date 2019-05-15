package com.alg.array;

import java.util.Arrays;

public class OnlyOneChar {
    public static void main(String[] args) {
        System.out.println(onlyOneChar("aabccddeeell,,"));
    }

    public static char onlyOneChar(String s) {
        int[] res = new int[255];

        Arrays.fill(res, 0);

        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            res[c]++;
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) {
                return (char) i;
            }

        }
        return '1';
    }
}
