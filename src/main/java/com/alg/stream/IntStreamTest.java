package com.alg.stream;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }
}
