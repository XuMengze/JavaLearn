package com.alg.java_core;

public class OuterClassStatic {
    private String s = "hh";

    class Inner {
        private String s = "hh2";

        public void print() {
            System.out.println(OuterClassStatic.this.s);
        }
    }

    public static void main(String[] args) {

        OuterClassStatic m = new OuterClassStatic();
        m.new Inner().print();
    }
}
