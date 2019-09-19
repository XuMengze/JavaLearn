package com.alg.simulation;

import java.util.*;

public class PouringWater {
    public static void main(String[] args) {

    }

    public int MinSteps(int m, int n, int k) {
        int step = 0;
        Stack<Integer> stackM = new Stack<Integer>();
        Stack<Integer> stackN = new Stack<Integer>();
        while (stackM.size() != m) {
            stackM.push(1);
        }
        step++;
        while (stackN.size() != n) {
            stackN.push(stackM.pop());
        }
        step++;
        if (stackM.size() == k) {
            return step;
        } else {
            stackN.clear();
            step++;
            boolean f1 = true;
            while (f1) {
                while (!stackM.isEmpty() && stackN.size() <= n) {
                    if (stackN.size() == n) {
                        if (stackM.size() == k) {
                            return step + 1;
                        } else {
                            step++;
                            stackN.clear();
                            step++;
                            f1 = true;
                        }
                    }
                    stackN.push(stackM.pop());
                }
                step++;
                if (stackM.isEmpty()) {
                    while (stackM.size() < m) {
                        stackM.push(1);
                    }
                    step++;
                    f1 = true;
                }
            }
        }
        return step;
    }
}
