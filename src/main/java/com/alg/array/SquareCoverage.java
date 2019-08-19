package com.alg.array;

import java.util.Arrays;
import java.util.Scanner;

public class SquareCoverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int spot = sc.nextInt();
        long[] x = new long[spot];
        long[] y = new long[spot];
        for (int i = 0; i < spot; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        long smallestX = Arrays.stream(x).min().getAsLong();
        long smallestY = Integer.MAX_VALUE;

        long biggestX = Arrays.stream(x).max().getAsLong();
        long biggestY = Integer.MIN_VALUE;
        for (int i = 0; i < spot; i++) {
            if (x[i] == smallestX && y[i] < smallestY) {
                smallestY = y[i];
                continue;
            }
            if (x[i] == biggestX && y[i] > biggestY) {
                biggestY = y[i];
            }
        }

        long size = Math.max(biggestX - smallestX, biggestY - smallestY);
        System.out.println(Math.round(Math.pow(size, 2)));

    }
}
