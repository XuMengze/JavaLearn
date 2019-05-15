package com.alg.array;

import com.alg.model.Tuple;

import java.util.Arrays;

public class MinSum {
    public static void main(String[] args) {

    }

    void switchEle(int[] arr1, int[] arr2) {


        int A = Math.abs(sumOfArray(arr1) - sumOfArray(arr2));
        Tuple<Integer, Integer> tuple;
        int baseline = 10000;

        if (sumOfArray(arr1) > sumOfArray(arr2)) {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if (Math.abs((arr1[i] - arr2[j]) - A / 2.0) < baseline) {
                        baseline = Math.abs((arr1[i] - arr2[j]) - A / 2);
                        tuple = new Tuple<>(i, j);
                    }
                }
            }
        } else {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if (Math.abs((arr2[i] - arr1[j]) - A / 2.0) < baseline) {
                        baseline = Math.abs((arr1[i] - arr2[j]) - A / 2);
                        tuple = new Tuple<>(j, i);
                    }
                }
            }
        }
    }

    int sumOfArray(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
