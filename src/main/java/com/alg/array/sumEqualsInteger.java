package com.alg.array;

import java.util.ArrayList;

public class sumEqualsInteger {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length / 2 + 1; i++) {
            int rest = sum - array[i];
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] == rest) {
                    result.add(array[i]);
                    result.add(array[j]);
                }
            }
        }
        return result;
    }

}
