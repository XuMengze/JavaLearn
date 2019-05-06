package com.alg.dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");

    }

    public static boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] canSplit = new boolean[len + 1];
        canSplit[0] = true;
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (canSplit[j] && dict.contains(s.substring(j, i))) {
                    canSplit[i] = true;
                }
            }

        }
        return canSplit[len];
    }
}
