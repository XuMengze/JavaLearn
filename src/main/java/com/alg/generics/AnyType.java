package com.alg.generics;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

class Fruit<T> {
    private List<T> list = new ArrayList<>();

    public Fruit() {
    }
}

public class AnyType {
    Fruit<Integer> f = new Fruit<>();

    public static void main(String[] args) {
        List<?> l = new ArrayList<>();
//        l.add(1);
//        l.add();
    }
}
