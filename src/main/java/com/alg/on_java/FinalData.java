package com.alg.on_java;

import com.alg.array.Fibnacci;
import com.alg.juc.F;

import java.util.Random;

class Value{
    int i;

    public Value(int i) {
        this.i = i;
    }
}
public class FinalData {
    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
        blank = 1;
    }
    private final int blank;
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;
    private static final int i4 = rand.nextInt(20);
    public static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    private final int[] a = {1,2,3,4,5,6,};

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
//        fd1.valueOne++;
        fd1.v2.i++;
        fd1.v1 = new Value(10);
//        fd1.v2 = new Value(10);
//        fd1.a = new int[3];
    }
}

