package com.alg.effective_java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsSubType {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        unsafeAdd(list, Integer.valueOf("10"));
        System.out.println(list.get(0));

        List<?> list2 = new ArrayList<>();
//        list2.add("s");
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
