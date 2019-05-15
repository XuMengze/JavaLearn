package com.alg.String;

public class LongestPalindrome {
    public static void main(String[] args) {

    }

    static int LP(String str) {
        int n = str.length();
        boolean[][] pal = new boolean[n][n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j) && (i - j < 2 || pal[j + 1][i - 1] == true)) {
                    pal[j][i] = true;
                    maxLen = Math.max(maxLen, i - j + 1);
                }
            }
        }
        return maxLen;

    }
}
