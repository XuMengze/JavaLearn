package com.alg.dp;

import java.util.*;

public class TwoModification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sample = sc.nextInt();
        String[] testSample = new String[sample];
        for (int i = 0; i < sample; i++) {
            testSample[i] = sc.next();
        }
        for (String s : testSample) {
            System.out.println(deal(s));
        }
    }

    public static int deal(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        int L = 0, R = 0, change = 0, ans = 1;
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) != 'N') {
                if (change < 2) {
                    change++;
                    R++;
                } else {
                    while (L <= R && s.charAt(L) == 'N') L++;
                    L++;
                    R++;
                }
            } else R++;
        }
        return Math.max(ans, R - L);
    }

    public static int deal2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] hash = new int[26];
        int maxOccur = ++hash[s.charAt(0) - 'A'];
        int maxLen = 1;
        int start = 0;
        for (int end = 1; end < s.length(); end++) {
            maxOccur = Math.max(maxOccur++, ++hash[s.charAt(end) - 'A']);
            if (end - start + 1 > maxOccur + 2) {
                hash[s.charAt(start++) - 'A']--;
            } else {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }
        return maxLen;
    }
}
