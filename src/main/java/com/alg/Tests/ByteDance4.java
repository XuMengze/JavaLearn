package com.alg.Tests;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ByteDance4 {

    public static void main(String[] args) {
//        int rodNum, lineNum;
//        Scanner sc = new Scanner(System.in);
//        rodNum = sc.nextInt();
//        lineNum = sc.nextInt();
//        int[] line = new int[rodNum];
//        for (int i = 0; i < rodNum; i++) {
//            line[i] = sc.nextInt();
//        }

        int[] test = {1, 2, 4, 7};

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(process(test, 4));

    }

    public static double process(int[] rod, int num) {
        Arrays.sort(rod);
        System.out.println(rod[0]);
        int len = rod.length;

        double cut = rod[len - 1] / ((double) num);
        if (cut > rod[len - 2]) {
            return cut;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (cut > rod[i]) {
                return Math.min(rod[i + 1], cut);

            } else if (cut == rod[i]) {
                return Math.min(rod[i], cut);
            }
        }
        return 0;
    }
}