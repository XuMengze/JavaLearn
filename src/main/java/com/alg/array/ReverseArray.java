package com.alg.array;

import java.util.Arrays;

public class ReverseArray {
    public int minNumberInRotateArray(int [] array) {
        return Arrays.stream(array).min().getAsInt();
    }
}
