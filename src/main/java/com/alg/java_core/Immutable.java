package com.alg.java_core;

import com.google.common.collect.Maps;

import java.util.Map;

public class Immutable {

    private static final Map<Integer, String> map = Maps.newHashMap();

    static {
        map.put(1, "one");
        map.put(2, "two");
    }

    public static void main(String[] args) {
        map.put(1, "three");
        System.out.println(map.get(1));
    }
}
