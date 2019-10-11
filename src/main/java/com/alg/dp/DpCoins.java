package com.alg.dp;

public class DpCoins {
    public static void main(String[] args) {
        DpCoins m = new DpCoins();
        m.minCoins(11, 3);
    }

    int minCoins(int input1, int input2) {
        // Write code here...
        int[] prime_array = new int[input2];
        int index = 0;
        int prime = 2;
        while (index < input2) {
            if (isPrime(prime)) {
                prime_array[index++] = prime;
                prime++;
            }
        }

        int[] dp = new int[input1 + 1];
        for (int i = 0; i <= input1; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i <= input1; i++) {
            for (int j = 0; j < prime_array.length; j++) {
                if (i - prime_array[j] >= 0 && dp[i - prime_array[j]] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - prime_array[j]]) {
                        dp[i] = dp[i - prime_array[j]] + 1;
                    }
                }
            }
        }

        return dp[input1];
    }

    boolean isPrime(int n) {
        int bound = (int) Math.sqrt(n);
        for (int i = 2; i <= bound; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
