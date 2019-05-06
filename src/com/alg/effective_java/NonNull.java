package com.alg.effective_java;

import java.util.Objects;

public class NonNull {
    public static void main(String[] args) {
        testNonNull(null);
    }

    public static void testNonNull(String s) {
        s = Objects.requireNonNull(s,"shenmegui");
        System.out.println(s);
    }
}
