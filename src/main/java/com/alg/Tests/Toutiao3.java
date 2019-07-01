package com.alg.Tests;

import java.util.ArrayList;
import java.util.Scanner;

public class Toutiao3 {
    static class Item {
        int totalValue = 0;
        ArrayList<Integer> itemLink = new ArrayList<>();
    }

    static ArrayList<Integer> solve1(int[] price, int[] weigh, int v) {
        int len = price.length;
        Item[] table = new Item[v + 1];
        for (int i = 0; i <= v; i++) {
            table[i] = new Item();
        }
        for (int i = 0; i < len; i++) {
            for (int j = weigh[i]; j <= v; j++) {
                int result2 = table[j - weigh[i]].totalValue;
                int result1 = table[j].totalValue;
                if (result1 < result2 + price[i]) {
                    table[j].totalValue = result2 + price[i];
                    table[j].itemLink.clear();
                    table[j].itemLink.addAll(table[j - weigh[i]].itemLink);
                    table[j].itemLink.add(i + 1);

                }
            }
        }
        return table[v].itemLink;
    }

    public static void main(String[] args) {

        int[] v = {1, 1, 1};
        int[] w = {350, 200, 150};

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[] moneys = new int[test];
        for (int i = 0; i < test; i++) {
            moneys[i] = sc.nextInt();
        }
        for (Integer money : moneys) {
            int sum = 0;
            for (Integer i : solve1(v, w, money)) {
                sum += w[i - 1];
            }
            System.out.println(money - sum);
        }
    }

}
