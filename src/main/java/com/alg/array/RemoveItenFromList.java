package com.alg.array;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class RemoveItenFromList {
    public static void main(String[] args) {
        List listTest = Lists.newArrayList("1", "2", "3", "4");
        Iterator<String> it = listTest.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("2")) {
                it.remove();
            }
        }
        System.out.println(listTest);
    }
}
