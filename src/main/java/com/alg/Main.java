package com.alg;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pupilNum = sc.nextInt();
        int[] scores = new int[pupilNum];
        for (int i = 0; i < pupilNum; i++) {
            scores[i] = sc.nextInt();
        }
        int queryNum = sc.nextInt();
        int[] querys = new int[queryNum];
        for (int i = 0; i < queryNum; i++) {
            querys[i] = sc.nextInt();
        }
        int[] sortedScore = scores.clone();
        Arrays.sort(sortedScore);

        for (Integer i : querys) {
            System.out.println(getFenweishu(sortedScore, scores[i - 1], pupilNum));
        }

    }

    public static String getFenweishu(int[] sortedScore, int score, int num) {
        int findFirst = bsearchfirst(sortedScore, score);
        double fenweishu = findFirst / Double.valueOf(num + "") * 100;
        return String.format("%.6f", fenweishu);
    }

    public static int bsearchfirst(int[] arr, int target) {
        int start = 0, end = arr.length, mid;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start] == target ? start : -1;
    }
}
