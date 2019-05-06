package com.alg.Tests;

import java.math.BigInteger;
import java.util.*;

public class Tencent3 {

    public static void main(String[] args) {
        int number, score;
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        score = sc.nextInt();

        int[] card = new int[number];

        for (int i = 0; i < number; i++) {
            card[i] = sc.nextInt();
        }
        if (score > number) {
            System.out.println(0);
            return;
        }
        BigInteger res = fact(number).divide(fact(score).multiply(fact(number - score))).multiply(new BigInteger((int) (Math.pow(2, number - score)) + ""));
        System.out.println(res.mod(new BigInteger(1000000007 + "")));
    }

    public static BigInteger fact(int num) {
        int temp = 1;
        BigInteger factorial = new BigInteger("1");
        while (num >= temp) {
            factorial = factorial.multiply(new BigInteger(temp + ""));
            temp++;
        }
        return factorial;
    }
}
