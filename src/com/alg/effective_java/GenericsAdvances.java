package com.alg.effective_java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenericsAdvances {
    public static void main(String[] args) {
        System.out.println(pickTwo(".", ",", "!")[0]);
//        String[] res = pickTwo(".", ",", "!");
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    public static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError();
    }

    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> res = new ArrayList<>();
        for (List<? extends T> list : lists) {
            res.addAll(list);
        }
        return res;
    }
}
