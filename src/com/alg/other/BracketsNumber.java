package com.alg.other;

import java.util.HashSet;
import java.util.Set;

public class BracketsNumber {
    public static final int numOfBrackets = 4;

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("()");
        for (int i = 0; i <= numOfBrackets - 2; i++) {
            set = addBrackets(set);
        }
        System.out.println(set);
    }

    static Set<String> addBrackets(Set<String> inputSet) {
        Set<String> outputSet = new HashSet<>();
        for (String in : inputSet) {
            for (int i = 0; i <= in.length(); i++) {
                outputSet.add(in.substring(0, i) + "()" + in.substring(i, in.length()));
            }
        }
        return outputSet;
    }
}
