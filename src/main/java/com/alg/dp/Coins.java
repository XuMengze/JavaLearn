package com.alg.dp;


public class Coins {
    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        System.out.println(getNumOfCoins(coins, 6249));
    }

    public static int getNumOfCoins(int[] coins, int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1000000;
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 0, len = coins.length; j < len; j++) {
                if (i > coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                } else if (i == coins[j]) {
                    dp[i] = 1;
                } else {
                    continue;
                }
            }
        }
        return dp[num];
    }
}
