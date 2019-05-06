package com.alg.probablity;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Roll6Dice {
    public static void main(String[] args) {
        Map<Integer, Double> map = rollDice();
        double total = 0;
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
            total += Double.parseDouble(entry.getValue() + "");
        }
        System.out.println(total);
    }

    static Map<Integer, Double> rollDice() {
        Random r = new Random();
        int diceSum = 0;

        Map<Integer, Double> map = new TreeMap();

        for (int i = 1; i < 100000; i++) {
            diceSum = 0;
            for (int j = 0; j < 6; j++) {
                diceSum += r.nextInt(6) + 1;
            }
            if (map.get(diceSum) != null) {
                map.put(diceSum, map.get(diceSum) + 1);
            } else {
                map.put(diceSum, 1.0);
            }
        }
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue() / 100000);
        }
        return map;
    }
}
