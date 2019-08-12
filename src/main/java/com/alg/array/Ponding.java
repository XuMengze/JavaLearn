package com.alg.array;

import java.util.Arrays;

public class Ponding {
    private static int[] array = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    private static int mount = 0;

    public static void main(String[] args) {
//        // 总层数
//        int top = 0;
//        // 当前层
//        int level = 0;
//        // 是否存在左墙
//        boolean haveLeft = false;
//        // 单层累加
//        int subMount = 0;
//        // 一层一层计算
//        while (true) {
//            for (int val : array) {
//                if (level == 0) {
//                    // 第一次循环需要计算总层数
//                    if (val > top) {
//                        top = val;
//                    }
//                }
//                if (haveLeft) {
//                    if (val <= level) {
//                        subMount++;
//                    } else {
//                        // 发现右墙，那么结算
//                        mount = mount + subMount;
//                        subMount = 0;
//                    }
//                } else {
//                    haveLeft = val > level;
//                }
//            }
//            // 达到最顶层那么跳出循环
//            level++;
//            if (level == top) {
//                break;
//            }
//            // 计算下一层，那么单层累加需要清空，左墙也需要清空
//            subMount = 0;
//            haveLeft = false;
//        }
//        System.out.println(mount);
//        System.out.println(getGut(array, 0, array.length - 1));
        int water = 0;
        for (int i = 1; i <= 3; i++) {
            water += getGut2(array, i);
        }
        System.out.println(water);
    }

    static int getGut(int arr[], int left, int right) {
        int water, L, R;
        if (right - left <= 1) {
            return 0;
        } else {
            L = findMaxIndex(arr, left, right);
            R = findSecondMaxIndex(arr, left, right);
            L = Math.min(L, R);
            R = Math.max(L, R);
            water = (R - L - 1) * Math.min(arr[L], arr[R]);
            for (int i = L + 1; i <= R - 1; i++) {
                water -= arr[i];
            }
        }
        return water + getGut(arr, left, L) + getGut(arr, R, right);

    }

    static int findMaxIndex(int[] arr, int left, int right) {
        int max = arr[left], maxindex = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxindex = i;
            }
        }
        return maxindex;
    }

    static int findSecondMaxIndex(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return -1;
        }
        int max, maxindex, secondMax, secondMaxindex;
        if (arr[left] > arr[left + 1]) {
            max = arr[left];
            maxindex = left;
            secondMax = arr[left + 1];
            secondMaxindex = left + 1;
        } else {
            max = arr[left + 1];
            maxindex = left + 1;
            secondMax = arr[left];
            secondMaxindex = left;
        }
        for (int i = left + 2; i <= right; i++) {
            if (arr[i] > max) {
                secondMax = max;
                secondMaxindex = maxindex;
                max = arr[i];
                maxindex = i;
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
                secondMaxindex = i;
            }
        }
        return secondMaxindex;
    }

    static int getGut2(int[] arr, int n) {
        int L = 0;
        int R = arr.length - 1;
        for (int i = L; i <= R; i++) {
            if (arr[i] >= n) {
                L = i;
                break;
            }
        }
        for (int i = R; i >= L; i--) {
            if (arr[i] >= n) {
                R = i;
                break;
            }

        }
        return Math.max(0, R - L - 1 - getSumSubArr(arr, L, R, n));
    }

    static int getSumSubArr(int[] arr, int L, int R, int n) {
        int sum = 0;
        for (int i = L + 1; i < R; i++) {
            if (arr[i] >= n) {
                sum++;
            }
        }
        return sum;
    }
}
