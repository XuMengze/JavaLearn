package com.alg.generics;

import java.lang.reflect.InvocationTargetException;

public class Erased<T> {
    public static final int SIZE = 100;
    Class<T> kind;

    public Erased(Class<T> kind) {
        this.kind = kind;
    }

    public boolean isClass(Object arg) {
        return kind.isInstance(arg);
    }

    public T getInstance() {
        try {
            return kind.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
