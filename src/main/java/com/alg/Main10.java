package com.alg;

import java.util.Arrays;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] height = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            height[i] = sc.nextInt();
        }
        int[] res = new int[cnt];
        for (int i = cnt - 1; i >= 0; i--) {
            if (i == cnt - 1) {
                res[i] = 0;
            } else {
                int heigherCnt = 0;
                for (int j = i + 1; j < cnt; j++) {
                    if (height[j] > height[i]) {
                        heigherCnt++;
                    }
                }
                res[i] = cnt - (i+1) - heigherCnt - res[i + 1];
            }
        }
        int index = -1;
        int maxVal = -1;
        for (int i = 0; i < cnt; i++) {
            if (res[i] > maxVal) {
                index = i;
                maxVal = res[i];
            }
        }

        System.out.println(height[index]);
    }
}
