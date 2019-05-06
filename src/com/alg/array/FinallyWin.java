package com.alg.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinallyWin {
    public static final int N = 4;

    public static void main(String[] args) {
        int[][] w = {
                {0, 1, 2, 3, 4},
                {1, 1, 2, 3, 4},
                {2, 2, 2, 3, 4},
                {3, 3, 3, 3, 4},
                {4, 4, 4, 4, 4}};
        int[] order = {4, 3, 1, 2, 0};
        getResOrder(w, order);

    }

    public static void getResOrder(int[][] w, int[] order) {
        List ord = new ArrayList();
        for (int i : order) {
            ord.add(i);
        }
        List res = new ArrayList();

        System.out.println(ord.size());
        while (ord.size() > 1) {
            int i = 0;
            while (i + 1 < ord.size()) {
                if ((int) ord.get(i) == w[(int) ord.get(i)][(int) ord.get(i + 1)]) {
                    res.add(ord.get(i + 1));
                    ord.remove(i + 1);
                } else {
                    res.add(ord.get(i));
                    ord.remove(i);
                }
                i += 2;
            }
        }
        System.out.println(Arrays.asList(res));
    }

}
