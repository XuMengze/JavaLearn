package com.alg.array;

public class OverHalf {
    public static void main(String[] args) {

    }

    public int MoreThanHalfNum_Solution(int[] array) {
        int times = 1, num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == num) {
                times++;
            } else {
                if (times == 0) {
                    times = 1;
                    num = array[i];
                } else {
                    times--;
                }
            }
        }

        int appear = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                appear++;
            }
        }
        if (appear > array.length / 2) {
            return num;
        } else return 0;
    }
}
