package com.alg.array;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ArrayAsAnObject {

    public static void main(String[] args) throws Exception {
        double[] arr = new double[10];
//        Field f = arr.getClass().getField("length");
//        System.out.println(f);
        Field[] fs = new Object().getClass().getDeclaredFields();
        for (Field f : fs
        ) {
            System.out.println(f.getName());
        }
        Method[] ms = new Object().getClass().getDeclaredMethods();
        for (Method m : ms
        ) {
            System.out.println(m.getName());
        }

        int a = 1;
        System.out.println(a);
    }
}
