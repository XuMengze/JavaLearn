package com.alg.dp;

public class ClimbStairs {
    public static void main(String[] args) {
        int step = 10;
        System.out.println(climb(10));
    }

    public static int climb(int steps) {
        int[] resArr = new int[steps + 1];
        resArr[0] = 0;
        resArr[1] = 1;
        resArr[2] = 2;
        for (int i = 3; i <= steps; i++) {
            resArr[i] = resArr[i - 1] + resArr[i - 2];
        }
        return resArr[steps];
    }
}
