package com.alg.Tests;

import java.math.BigDecimal;

public class ClimbStairs {
    public static void main(String[] args) {
        int stairs = 12;
        System.out.println(climb(stairs));
    }

    public static BigDecimal climb(int stairs) {
        BigDecimal[] dp = new BigDecimal[stairs + 1];
        dp[1] = new BigDecimal("1");
        dp[2] = new BigDecimal("2");
        for (int i = 3; i <= stairs; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        return dp[stairs];
    }
}
