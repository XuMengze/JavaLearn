package com.alg.on_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3));
        Collections.addAll(new ArrayList<>(), 1,2);
    }
}
record Employee(String name){}