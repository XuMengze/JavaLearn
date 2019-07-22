package com.alg.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Foursums {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        Foursums so = new Foursums();
        List<List<Integer>> res = so.test(nums, target);

        System.out.println(res);
    }

    List<List<Integer>> test(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                int restSum = target - nums[i] - nums[j];

                while (m < n) {
                    if (restSum == nums[m] + nums[n]) {
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[m]);
                        tmpList.add(nums[n]);
                        res.add(tmpList);
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[m - 1]) {
                            n--;
                        }
                        m++;
                        n--;
                    } else if (nums[m] + nums[n] < restSum) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }
        return res;
    }
}