package com.alg.array;

public class AppearanceOverHalf {
    public static void main(String[] args) {
        int[] inputArr = {1, 3, 3, 2, 3, 2, 3, 3, 2};
        System.out.println(getThatNum(inputArr));
    }

    static int getThatNum(int[] in) {

        int num = in[0];
        int times = 1;

        for (int i = 1; i < in.length; i++) {
            if (num == in[i]) {
                times++;
            } else {
                if (times >= 1) {
                    times--;
                } else {
                    num = in[i];
                    times = 1;
                }
            }
        }
        return num;
    }
}
