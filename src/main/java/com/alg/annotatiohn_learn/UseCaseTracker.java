package com.alg.annotatiohn_learn;

import java.lang.reflect.Method;
import java.util.List;

public class UseCaseTracker {
    public static void tracker(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase u = m.getAnnotation(UseCase.class);
            if (u != null) {
                System.out.println("Found Use Case id = " + u.id() + "desc = " + u.description());
            }
            useCases.remove(Integer.valueOf(u.id()));
        }
        useCases.forEach(i -> System.out.println("Missing use case " + i));
    }

    public static void main(String[] args) {

    }
}
