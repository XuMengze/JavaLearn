package com.alg.effective_java;

import java.util.EnumMap;

public class OperationMain {
    public static void main(String[] args) {
        System.out.println(Operation.values());
        new EnumMap<>(Operation.class);
    }
}
