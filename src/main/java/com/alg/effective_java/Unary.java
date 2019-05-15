package com.alg.effective_java;

import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

public class Unary {

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("Hash1");
        s1.add("Hash2");
        s1.add("Hash3");
        for (String s :
                s1) {
            System.out.println(identifyFunction().apply(s));
        }
    }

    public static <T> UnaryOperator<T> identifyFunction() {
        return (t) -> (T) (t.toString() + "hh");
    }
}
