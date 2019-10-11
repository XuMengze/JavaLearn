package com.alg.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShufflePrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] primes = new int[n + 1];
        int i, j = 2;
        while (j < n + 1) {
            if (primes[j] == 0) {
                for (i = j + 1; i < n + 1; i++) {
                    if (i % j == 0) {
                        primes[i] = 1;
                    }
                }
            }
            j++;
        }
        List<Integer> res = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (k >= 2 && primes[k] == 0 && (k - 1) % 10 == 0) {
                res.add(k);
            }
        }
        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(resToStr(res));
        }
    }

    private static String resToStr(List<Integer> res) {
        StringBuilder sb = new StringBuilder("");
        for (Integer i : res) {
            sb.append(i).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
