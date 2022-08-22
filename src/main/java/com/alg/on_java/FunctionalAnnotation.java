package com.alg.on_java;

import com.alg.juc.F;

import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

public class FunctionalAnnotation {
    public String goodbye(String a) {
        return "Goodbye, " + a;
    }

    public static void main(String[] args) {
        Functional f = new FunctionalAnnotation()::goodbye;
        FunctionalNoAnn f2 = new FunctionalAnnotation()::goodbye;
        Functional f3 = (a) -> "Goodbye, " + a;
        FunctionalNoAnn f4 = (a) -> "Goodbye, " + a;
        BooleanSupplier bs = ()->true;
    }
}
