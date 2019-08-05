package com.alg.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GreedyPickNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int[] nums = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            nums[i] = scanner.nextInt();
        }
        int start = 0, end = numCount - 1;
        List<Integer> aMove = new ArrayList<>();
        List<Integer> bMove = new ArrayList<>();
        while (start <= end) {
            if (aMove.size() == 0) {
                if (Math.abs(nums[start] - 0) >= Math.abs(nums[end] - 0)) {
                    aMove.add(nums[start]);
                    start++;
                } else {
                    aMove.add(nums[end]);
                    end--;
                }
            } else {
                if (Math.abs(nums[start] - aMove.get(aMove.size() - 1)) >= Math.abs(nums[end] - aMove.get(aMove.size() - 1))) {
                    aMove.add(nums[start]);
                    start++;
                } else {
                    aMove.add(nums[end]);
                    end--;
                }
            }
            if (start > end)
                break;
            if (bMove.size() == 0) {
                if (Math.abs(nums[start] - 0) >= Math.abs(nums[end] - 0)) {
                    bMove.add(nums[start]);
                    start++;
                } else {
                    bMove.add(nums[end]);
                    end--;
                }
            } else {
                if (Math.abs(nums[start] - bMove.get(bMove.size() - 1)) >= Math.abs(nums[end] - bMove.get(bMove.size() - 1))) {
                    bMove.add(nums[start]);
                    start++;
                } else {
                    bMove.add(nums[end]);
                    end--;
                }
            }
        }
        int sa = Math.abs(aMove.get(0) - 0), sb = Math.abs(bMove.get(0) - 0);
        for (int i = 1; i < aMove.size(); i++) {
            sa += (Math.abs(aMove.get(i) - aMove.get(i - 1)));
        }
        for (int i = 1; i < bMove.size(); i++) {
            sb += (Math.abs(bMove.get(i) - bMove.get(i - 1)));
        }
        System.out.println(sa + " " + sb);
    }
}
