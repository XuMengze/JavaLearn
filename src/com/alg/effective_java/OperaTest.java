package com.alg.effective_java;

public class OperaTest {
    public static void main(String[] args) {
        double x = 1.1;
        double y = 22;
        for (Opera op : OperaExtended.class.getEnumConstants()){
            System.out.println(op);
        }
    }
}
