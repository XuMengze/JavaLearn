package com.alg.on_java;

class Process {
    public String name() {
        return this.getClass().getSimpleName();
    }

    public Object process(Object input) {
        return input;
    }
}

class Uppercase extends Process {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

public class Applicator {
    public static void apply(Process p, Object s){
        System.out.println("Using Process"+p.name());
        System.out.println(p.process(s));
    }
    public static void main(String[] args) {
        Process p = new Uppercase();
        System.out.println(p.name());
    }
}
