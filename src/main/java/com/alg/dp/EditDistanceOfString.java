package com.alg.dp;

public class EditDistanceOfString {
    public static void main(String[] args) {
        System.out.println(getEditDistance2("kitten", "sitting"));

    }

    static int getEditDistance(String s1, String s2) {
        int[][] edit = new int[s1.length() + 1][s2.length() + 1];
        edit[0][0] = 0;
        for (int i = 1; i <= s1.length(); i++) edit[i][0] = i;
        for (int j = 1; j <= s2.length(); j++) edit[0][j] = j;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    edit[i + 1][j + 1] = Math.min(edit[i][j], Math.min(edit[i + 1][j] + 1, edit[i][j + 1] + 1));
                } else {
                    edit[i + 1][j + 1] = Math.min(edit[i][j] + 1, Math.min(edit[i + 1][j] + 1, edit[i][j + 1] + 1));
                }
            }
        }
        return edit[s1.length()][s2.length()];
    }

    static int getEditDistance2(String s1, String s2) {
        return Math.max(s1.length(), s2.length()) - LongestCommonSequence.LCS(s1, s2);
    }


}
