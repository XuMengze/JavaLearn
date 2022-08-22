package com.alg.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomList<T> extends ArrayList<T> {
    private static Random rand = new Random(47);

    public T select() {
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        rs.addAll(Arrays.asList("Hi Nice To Meet You.".split(" ")));
        IntStream.range(1, 10).forEach((i) -> System.out.println(rs.select()));
    }
}
