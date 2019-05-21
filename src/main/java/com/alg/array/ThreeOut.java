package com.alg.array;

import java.util.stream.Stream;

public class ThreeOut {
    public static void main(String[] args) {
        System.out.println(getSurvivor(50, 3));

    }

    public static int getSurvivor(int partitcipants, int num) {
        int[] posArr = new int[partitcipants];
        for (int i = 0; i < partitcipants; i++) {
            posArr[i] = i + 1;
        }

        int start = -1, call = 0;
        while (partitcipants > 1) {
            start++;
            if (posArr[start % posArr.length] == 0) {
                continue;
            }
            if ((call + 1) % num == 0) {
                posArr[start % posArr.length] = 0;
                partitcipants--;
            }
            call++;
        }

        for (Integer i : posArr) {
            if (i > 0) {
                return i;
            }
        }
        return -1;
    }

}
