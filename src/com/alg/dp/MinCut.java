package com.alg.dp;

public class MinCut {
    public static void main(String[] args) {
        System.out.println(minCut("cdd"));
    }

    public static int minCut(String s) {
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
            if (dp[i] == 0)
                continue;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s.substring(j, i + 1)))
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                else
                    dp[i] = Math.min(dp[i], dp[j - 1] + i + 1 - j);
            }
        }
        return dp[dp.length - 1];
    }

    public static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
