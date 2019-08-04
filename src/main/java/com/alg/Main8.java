package com.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main8 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            int bugCount = scanner.nextInt();
            int times = scanner.nextInt();
            int cups = scanner.nextInt();
            int[] bugTime = new int[bugCount];
            for (int i = 0; i < bugCount; i++) {
                bugTime[i] = scanner.nextInt();
            }
            int sum = Arrays.stream(bugTime).sum();
            if (cups > 8)
                cups = 8;
            if (60 * times * cups + ((8 - cups) * 60) < sum) {
                list.add(0);
            } else {
                if (cups * times * 60 > sum) {
                    list.add(Double.valueOf(Math.ceil(sum / Double.parseDouble(times + ""))).intValue());
                } else {
                    int nei = cups * 60;
                    int wai = sum - cups * times * 60;
                    list.add(nei + wai);
                }
            }
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
