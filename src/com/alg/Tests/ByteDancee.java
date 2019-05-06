package com.alg.Tests;

import java.util.Scanner;

public class ByteDancee {

    public static void main(String[] args) {
        int exampleNum;
        Scanner sc = new Scanner(System.in);
        exampleNum = sc.nextInt();
        for (int i = 0; i < exampleNum; i++) {
            int propleNum = sc.nextInt();
            int[] score = new int[propleNum];
        }

    }


    public static String solution(int[] score) {

        int[] ca = new int[score.length];
        for (int i = 0; i < ca.length; i++) {
            if (i == 0 && (score[0] < score[1] && score[0] < score[score.length - 1])) {
                ca[i] = 1;
            }
            if (i == ca.length - 1 && (score[ca.length - 1] < score[ca.length - 2] && score[0] < score[0])) {
                ca[ca.length - 1] = 1;
            }
            if (score[i] < score[i - 1] && score[i] < score[i + 1]) {
                ca[i] = 1;
            } else {
                ca[i] = 0;
            }
        }
        return null;

    }
}
