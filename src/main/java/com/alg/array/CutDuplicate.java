package com.alg.array;

import java.util.*;

public class CutDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        int[] rndNum = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            rndNum[i] = sc.nextInt();
        }
        Arrays.sort(rndNum);
        List<Integer> list = new ArrayList<>();
        for (Integer i : rndNum) {
            if (list.size() == 0) {
                list.add(i);
            }
            if (i == list.get(list.size() - 1)) {
                continue;
            } else {
                list.add(i);
            }
        }

        for (Integer i :
                list) {
            System.out.println(i);
        }
    }
}
