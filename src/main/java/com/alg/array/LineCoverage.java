package com.alg.array;

import java.util.Scanner;

public class LineCoverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int spot;
        spot = sc.nextInt();
        int len = sc.nextInt();
        int[] left = new int[spot];
        int[] right = new int[spot];
        for (int i = 0; i < spot; i++) {
            left[i] = sc.nextInt();
            right[i] = sc.nextInt();
        }
        int eend = 0;
        int rod = 0;
        while (eend < len) {
            int max = -1;
            int count = 0;
            for (int i = 0; i < spot; i++) {
                if (left[i] <= eend && right[i] > max && right[i] > eend) {
                    max = right[i];
                    eend = right[i];
                    rod++;
                } else {
                    count++;
                }
            }
            if (count == spot) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(rod);
    }
}
