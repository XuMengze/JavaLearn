package com.alg.generics;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class GenericImp {
    public static void main(String[] args) {
        ArrayList list1  = new ArrayList();
        ArrayList<String> list2  = new ArrayList<>();
        System.out.println(list1.getClass().getName() == list2.getClass().getName());
    }
}
