package com.alg.on_java;

interface Description {
    String brief();
}

interface Body {
    String detailed(String s);
}

interface Multi {
    String two(String head, Double d);
}

interface IntCall {
    int call(int arg);
}

public class Lambda {

    Description desc = () -> "HelloWorld";
    Multi mult = (h, n) -> h + n;
    Description desc2 = () -> {
        System.out.println("happy");
        return "more line()";
    };
    static IntCall fact;
    static IntCall fib;

    public static void main(String[] args) {
        fact = (n) -> n == 0 ? 1 : n * fact.call(n - 1);
        fib = (n) -> n == 0 ? 0 : n == 1 ? 1 : fib.call(n - 1) + fib.call(n - 2);
    }
}

@FunctionalInterface
interface Callable {
    void call(String s);
}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}

class MethodReference {
    static void hello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) {
        MakeAll m = Dog::new;
    }
}

@FunctionalInterface
interface MakeAll{
    Dog makeAll(String name, int age);
}
class Dog{
    String name;
    int age = -1;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}