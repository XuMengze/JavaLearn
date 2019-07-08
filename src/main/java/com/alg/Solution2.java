package com.alg;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(numAdd("162", "79"));
        System.out.println(162 + 79);
    }

    public static String numAdd(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int len1 = n1.length();
        int len2 = n2.length();
        int len = Math.max(len1, len2);

        //进位
        int c = 0;

        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                n1 += "0";
            }
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                n2 += "0";
            }
        }

        for (int i = 0; i < len; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + c;
            result.append(nSum % 10);
            c = nSum / 10;
        }

        if (c > 0) {
            result.append(c);
        }
        return result.reverse().toString();
    }
}
