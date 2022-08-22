package com.alg.generics;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<>(a);
        res.addAll(b);
        return res;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }

    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> res = new HashSet<>(superset);
        res.removeAll(subset);
        return res;
    }

    public static <T> Set<T> complete(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
