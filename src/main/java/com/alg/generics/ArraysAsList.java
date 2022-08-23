package com.alg.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.<Integer>asList(1, 2, 3, 4);
    }
}
