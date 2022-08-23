package com.alg.generics;

import com.google.common.base.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class IntegerFactory implements Supplier<Integer> {
    private int i = 0;

    @Override
    public Integer get() {
        return ++i;
    }
}

class Widget {
    private int id;

    public Widget(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Widget" + id;
    }

    static class Factory implements Supplier<Widget> {
        private int i = 0;

        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}

class Fudge {
    private static int count = 0;
    private int n = ++count;

    @Override
    public String toString() {
        return "Fudge" + n;
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();

    public Foo2(Supplier<T> factory) {
//        Suppliers.fill(x, factory, 5);
    }

    @Override
    public String toString() {
        return x.toString();
    }
}

public class FactoryConstraint {
}
