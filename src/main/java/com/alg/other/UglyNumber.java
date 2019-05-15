package com.alg.other;

import java.util.Arrays;

public class UglyNumber {
    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        System.out.println(getSuperUgly(4, primes));
    }

    static int getUgly(int n) {
        int fac2 = 1, fac3 = 1, fac5 = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int base = Math.min(fac2 * 2, Math.min(fac3 * 3, fac5 * 5));
            if (fac2 * 2 == base) {
                res = fac2 * 2;
                fac2++;
            }
            if (fac3 * 3 == base) {
                res = fac3 * 3;
                fac3++;
            }
            if (fac5 * 5 == base) {
                res = fac5 * 5;
                fac5++;
            }
        }
        return res;
    }

    static int getSuperUgly(int n, int[] primes) {
        int[] pointer = new int[primes.length];
        Arrays.fill(pointer, 0);
        int ugly[] = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[pointer[j]] * primes[j] < min) {
                    min = ugly[pointer[j]] * primes[j];
                    minIndex = j;
                } else if (ugly[pointer[j]] * primes[j] == min) {
                    pointer[j]++;
                }
            }
            ugly[i] = min;
            pointer[minIndex]++;
        }
        return ugly[n - 1];
    }
}
