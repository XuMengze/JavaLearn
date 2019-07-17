package com.alg.other;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Cartesian {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>() {{
            add("a");
            add("b");
            add("c");
        }};
        Set<String> s2 = new HashSet<>() {{
            add("d");
            add("e");
            add("f");
        }};

        System.out.println(getCartesianSet(s1, s2));
    }

    public static Set<String> getCartesianSet(Set<String>... s) {
        if (s.length == 0) {
            return new HashSet<>();
        } else if (s.length == 1) {
            return s[0];
        } else {
            Set<String> resSet = s[0];
            for (int i = 1; i < s.length; i++) {
                resSet = getCartesianSetTwo(resSet, s[i]);
            }
            return resSet;
        }
    }

    public static Set<String> getCartesianSetTwo(Set<String> s1, Set<String> s2) {
        Set<String> res = new LinkedHashSet<>();
        for (String former : s1) {
            for (String latter : s2) {
                res.add(former + latter);
            }
        }
        return res;
    }
}
