package com.alg.array;

public class InversePair {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    private long result;

    public long reversePairs(int[] A) {
        sort(A, 0, A.length - 1);
        return result;
    }

    private void sort(int[] num, int low, int high) {
        int mid = (high + low) / 2;
        if (low < high) {
            // 左边排序
            sort(num, low, mid);
            // 右边排序
            sort(num, mid + 1, high);
            // 左右合并
            mergeSort(num, low, mid, high);
        }
    }

    private void mergeSort(int[] num, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (num[i] <= num[j]) {
                temp[k++] = num[i++];

            } else {
                temp[k++] = num[j++];
                result += (mid - i + 1);
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = num[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = num[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            num[k2 + low] = temp[k2];
        }
    }
}
