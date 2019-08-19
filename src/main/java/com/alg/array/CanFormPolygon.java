package com.alg.array;

import java.util.Arrays;
import java.util.Scanner;

public class CanFormPolygon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] length = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            length[i] = sc.nextInt();
        }
        if (cnt <= 2) {
            System.out.println(-1);
            return;
        }
        for (int i = 2; i < cnt; i++) {
            int[] mid = new int[i + 1];
            System.arraycopy(length, 0, mid, 0, i + 1);
            Arrays.sort(mid);
            if (Arrays.stream(mid).sum() - mid[mid.length - 1] > mid[mid.length - 1]) {
                System.out.println(i + 1);
                break;
            }
            if (i == cnt - 1) {
                System.out.println(-1);
            }
        }
    }
}
