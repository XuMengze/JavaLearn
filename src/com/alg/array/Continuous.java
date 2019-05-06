package com.alg.array;

import java.util.Arrays;

public class Continuous {
    public static void main(String[] args) {
        int[] test = {1, 3, 2, 6, 4};
        boolean a = isContinuous(test);
        System.out.println(a);
    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int zeroNums = 0;
        for (int i = 0; i <= numbers.length - 2; i++) {
            if (numbers[i] == 0) {
                zeroNums++;
                continue;
            }
            if (numbers[i + 1] == numbers[i])
                return false;
            zeroNums -= (numbers[i + 1] - numbers[i] - 1);
        }
        return zeroNums >= 0;
    }
}
