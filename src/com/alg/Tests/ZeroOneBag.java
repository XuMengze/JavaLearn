package com.alg.Tests;

public class ZeroOneBag {
    public static void main(String[] args) {

        int[] volume = {5, 4, 3};
        int[] value = {20, 10, 12};
        int bagCapacity = 10;
        int[][] d = new int[volume.length][bagCapacity];
        for (int i = 1; i < volume.length; i++) {
            for (int j = 0; j < bagCapacity; j++) {
                if (j >= volume[i]) {
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - volume[i]] + value[i]);
                }
            }
        }
        System.out.println(d[2][9]);
    }
}
