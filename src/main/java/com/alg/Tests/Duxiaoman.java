package com.alg.Tests;

import java.util.Scanner;
public class Duxiaoman {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();

        int[] nodeWeight = new int[node];
        for (int i = 0; i < node; i++) {
            nodeWeight[i] = sc.nextInt();
        }

        int[] resarr = new int[node - 1];

        for (int i = 0; i < resarr.length; i++) {
            resarr[i] = getLineWeight(nodeWeight, i);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < resarr.length; i++) {
            res.append(resarr[i]).append(" ");
        }

        System.out.println(res.substring(0, res.length() - 1));
    }

    public static int getLineWeight(int[] nodeWeight, int index) {
        int res = 0;
        for (int i = 0; i <= index; i++) {
            for (int j = index + 1; j < nodeWeight.length; j++) {
                if (nodeWeight[i] != nodeWeight[j]) {
                    res++;
                }
            }
        }
        return res;
    }

}
