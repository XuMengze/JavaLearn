package com.alg.Tests;

import java.util.Arrays;

public class CoinsToGetMoney {


    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int[] min = new int[12];
        for (int i = 0; i < min.length; i++) {
            min[i] = 5;
        }
        min[0] = 0;
        for (int i = 1; i < 12; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && min[i - coins[j]] + 1 < min[i]) {
                    min[i] = min[i - coins[j]] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(min));
    }
}
