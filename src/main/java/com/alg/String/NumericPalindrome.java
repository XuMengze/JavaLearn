package com.alg.String;

public class NumericPalindrome {
    public static void main(String[] args) {
        System.out.println(reverseNumber(120));
    }

    public static int reverseNumber(int num) {
        int res = 0;
        int sign = num < 0 ? -1 : 1;

        num = Math.abs(num);

        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res * sign;
    }
}
