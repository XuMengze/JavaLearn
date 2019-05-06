package com.alg.Tests;

import java.math.BigInteger;
import java.util.Scanner;

public class Tencentcccc {

    public static void main(String[] args) {
        int number = 3, score = 2;


        if (score > number) {
            System.out.println(0);
            return;
        }

//        int res = fact(number) / (fact(score) * fact(number - score));
        BigInteger res = fact(number).divide(fact(score).multiply(fact(number - score)));
        System.out.println(res);
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
