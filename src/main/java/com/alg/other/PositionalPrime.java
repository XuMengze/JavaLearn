package com.alg.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionalPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        int count = 0;
        int start = 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            while (true) {
                start++;
                if (isPrime(start)) {
                    count++;
                    break;
                }
            }
            if (count >= left) {
                res.add(start);
            }
            if (count == right) {
                break;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (i % 10 == 9) {
                System.out.print(res.get(i) + "\n");
            } else if (i == res.size() - 1) {
                System.out.print(res.get(i));
            } else {
                System.out.print(res.get(i) + " ");
            }
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int barieer = (int) Math.round(Math.pow(n, 0.5));
        for (int i = 2; i <= barieer; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}