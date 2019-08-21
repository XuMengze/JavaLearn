package com.alg.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casesCnt = sc.nextInt();
        long[] A = new long[casesCnt];
        long[] B = new long[casesCnt];
        long[] C = new long[casesCnt];
        for (int i = 0; i < casesCnt; i++) {
            A[i] = sc.nextLong();
            B[i] = sc.nextLong();
            C[i] = sc.nextLong();
        }

        for (int i = 0; i < casesCnt; i++) {
            System.out.println("Case #" + (i+1) + ": " + (A[i] + B[i] > C[i]));
        }
    }
}
