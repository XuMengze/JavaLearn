package com.alg.generics;

import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Fibonacci implements Supplier<Integer> {
    private static Map<Integer, Integer> cache = new HashMap<>();
    private int count = 1;


    private int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n <= 2) {
            return 1;
        }
        int result = fib(n - 1) + fib(n - 2);
        cache.put(n, result);
        return result;
    }

    @Override
    public Integer get() {
        return fib(count++);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci()).limit(19).map(n -> n + " ").forEach(System.out::print);
    }
}

class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return get();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.println(i);
        }
    }

    public static <T> @NotNull List<T> makeList(T... args) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, args);
        return list;
    }
}
