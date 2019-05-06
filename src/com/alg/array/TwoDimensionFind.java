package com.alg.array;

import java.util.Arrays;

public class TwoDimensionFind {
    public static void main(String[] args) {


    }


    public static boolean Find(int target, int[][] array) {
        int height = array.length;
        int width = array[0].length;

        int beginRow = 0, endRow = height - 1;
        int mid = -1;
        while (beginRow < endRow) {
            mid = (beginRow + endRow) / 2;
            if (target >= array[beginRow][0] && target <= array[mid][0]) {
                endRow = mid;
            } else if (target <= array[endRow][0] && target >= array[mid][0]) {
                beginRow = mid;
            } else {
                return false;
            }
        }

        int beginCol = 0, endCol = width - 1;
        int midCol = -1;
        while (beginCol < endCol) {
            midCol = (beginCol + endCol) / 2;
            if (target >= array[mid][beginCol] && target <= array[mid][midCol]) {
                endCol = midCol;
            } else if (target <= array[mid][endCol] && target >= array[mid][midCol]) {
                beginCol = midCol;
            } else {
                return false;
            }
        }
        if (target == array[mid][midCol]) {
            return true;
        }
        return false;
    }
}
