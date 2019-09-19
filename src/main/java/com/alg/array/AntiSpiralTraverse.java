package com.alg.array;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AntiSpiralTraverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        System.out.println(printList(spiralOrder(num)));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int beginX, endX, beginY, endY;
        beginX = 0;
        endX = n - 1;
        beginY = 0;
        endY = m - 1;
        while (true) {
            // 从左上到左下
            for (int j = beginY; j <= endY; j++) {
                result.add(matrix[j][beginX]);
            }
            beginX++;
            if (beginX > endX)
                break;
            // 从左下到右下
            for (int i = beginX; i <= endX; i++) {
                result.add(matrix[endY][i]);
            }
            endY--;
            if (endY < beginY)
                break;
            // 从右下到右上
            for (int j = endY; j >= beginY; j--) {
                result.add(matrix[j][endX]);
            }
            endX--;
            if (endX < beginX)
                break;
            // 从右上到左上
            for (int i = endX; i >= beginX; i--) {
                result.add(matrix[beginY][i]);
            }
            beginY++;
            if (beginY > endY)
                break;
        }
        return result;
    }

    static String printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
