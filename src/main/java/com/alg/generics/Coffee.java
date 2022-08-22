package com.alg.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Coffee {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Mocha extends Coffee {
    public Mocha() {
    }
}

class Latte extends Coffee {
    public Latte() {
    }
}

class Cappuccino extends Coffee {
    public Cappuccino() {
    }
}

class Americano extends Coffee {
    public Americano() {
    }
}

class Breve extends Coffee {
    public Breve() {
    }
}

class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {
    private Random rand = new Random(47);
    private Class[] types = {Mocha.class, Latte.class, Cappuccino.class, Americano.class, Breve.class};

    private int size = 0;

    public CoffeeSupplier() {
    }

    public CoffeeSupplier(int size) {
        this.size = size;
    }

    @Override
    public Coffee get() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier()).limit(5).forEach(System.out::println);
        for (Coffee coffee : new CoffeeSupplier(5)) {
            System.out.println(coffee);
        }
    }
}