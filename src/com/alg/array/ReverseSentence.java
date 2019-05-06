package com.alg.array;

import java.util.Arrays;
import java.util.Collections;

public class ReverseSentence {
    public static void main(String[] args) {
        String input = "I am a student.";

        String[] resArr = input.split(" ");
        for (int i = 0, j = resArr.length - 1; i <= j; i++, j--) {
            String tmp = resArr[i];
            resArr[i] = resArr[j];
            resArr[j] = tmp;
        }
        System.out.println(Arrays.asList(resArr));
    }
}
