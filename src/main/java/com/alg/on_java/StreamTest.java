package com.alg.on_java;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
        System.out.println(new Random(47)
                .ints(5,10).
                boxed().
                limit(10).mapToInt((b)->b).sum());

        System.out.println( IntStream.range(1,10).sum());
    }
}
