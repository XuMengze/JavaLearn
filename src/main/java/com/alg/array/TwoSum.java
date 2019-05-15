package com.alg.array;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] numArr = {1, 8, 4, 7, 11, 15};
        System.out.println(twoSum(numArr, 15));
    }

    public static int twoSum(int[] numArr, int sum) {
        int[] hashArr = new int[1000];
        Arrays.fill(hashArr, 0);
        for (int single : numArr) {
            hashArr[single]++;
        }
        int resNum = 0;
        for (int single : numArr) {
            hashArr[single]--;
            if (hashArr[sum - single] > 0) {
                resNum++;
            }
            hashArr[single]++;
        }
        return resNum/2;
    }
}
