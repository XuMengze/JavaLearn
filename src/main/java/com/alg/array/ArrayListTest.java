package com.alg.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        System.out.print(list1.getClass() == list2.getClass());
        System.out.println(list2.getClass());
    }
}
