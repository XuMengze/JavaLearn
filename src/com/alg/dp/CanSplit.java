package com.alg.dp;

import java.util.HashSet;
import java.util.Set;

public class CanSplit {
    public static void main(String[] args) {
        String s = "catanddog";
        Set<String> dict = new HashSet<>();
//        dict.add("ca");
        dict.add("cat");
        dict.add("and");
        dict.add("dog");
        System.out.println(canBeSplit(dict, s));
    }

    public static boolean canBeSplit(Set<String> dict, String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                dp[i] = 1;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j] == 1 && dict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = 1;
                    }
                }
            }
        }
        return dp[len - 1] == 1;
    }
}
