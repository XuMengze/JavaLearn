package com.alg.effective_java;

import java.util.HashSet;
import java.util.Set;

public class GenericMethod {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("Hash1");
        s1.add("Hash2");
        s1.add("Hash3");
        Set<Integer> s2 = new HashSet<>();
        s2.add(10);
        s2.add(20);
        s2.add(30);

        Set<Object> s3 = union(s1, s2);

        System.out.println(s3);
    }

    public static <A> Set<A> union(Set<? extends A> s1, Set<? extends A> s2) {
        Set<A> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
