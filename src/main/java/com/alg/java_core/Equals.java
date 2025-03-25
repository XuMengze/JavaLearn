package com.alg.java_core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equals {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        System.out.println(list1.equals(list2));
        System.out.println(list1.getClass());
        System.out.println();
    }
}
