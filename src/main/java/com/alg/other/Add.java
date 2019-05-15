package com.alg.other;

public class Add {


    public static void main(String[] args) {
        int sum = fun(100);
        System.out.println(sum);
    }

    public static int fun(int n) {
        if (n > 0) {
            return n + fun(n - 1);
        }
        return 0;
    }
}
