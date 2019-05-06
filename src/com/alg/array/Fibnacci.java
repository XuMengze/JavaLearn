package com.alg.array;

public class Fibnacci {
    public static void main(String[] args) {

    }

    public int Fibonacci(int n) {
        int a = 0, b = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        if (n == 0) {
            return res;
        } else if (n == 1) {
            return 1;
        } else {
            return res;
        }
    }

}
