package com.alg;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main7 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();

        while (scanner.hasNextLine()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            Snack[] tr = new Snack[m];
            for (int i = 0; i < m; i++) {
                tr[i] = new Snack(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }
            res.add(solution1(tr, n));
        }
        for (Integer i : res
        ) {
            System.out.println(i);
        }
    }

    public static int solution1(Snack[] treasures, int totalVolume) {
        int maxValue = -1;
        if (treasures == null || treasures.length == 0 || totalVolume < 0) {
            maxValue = 0;
        } else {
            int treasuresClassNum = treasures.length;
            int[] f = new int[totalVolume + 1];
            for (int i = 0; i < treasuresClassNum; i++) {
                int currentVolume = treasures[i].volume;
                int currentValue = treasures[i].value;
                int currentNum = treasures[i].num;
                for (int j = totalVolume; j >= currentVolume; j--) {
                    for (int k = 0; k <= currentNum && k * currentVolume <= j; k++) {
                        f[j] = Math.max(f[j], f[j - k * currentVolume] + k * currentValue);
                    }
                }
            }
            maxValue = f[totalVolume];
        }
        return maxValue;
    }
}

class Snack {
    public int value;
    public int volume;
    public int num;

    public Snack(int volume, int value, int num) {
        this.value = value;
        this.volume = volume;
        this.num = num;
    }
}

