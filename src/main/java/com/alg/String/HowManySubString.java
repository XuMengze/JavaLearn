package com.alg.String;

import java.util.Arrays;
import java.util.Scanner;

public class HowManySubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        int[] res = new int[s.length()];
        int count = 0;
        for (int i = t.length() - 1, len = s.length(); i < len; i++) {
            if (s.substring(i - t.length() + 1, i + 1).equals(t)) {
                count++;
                Arrays.fill(res, i, i + t.length(), count);
                i += t.length() - 1;
            } else {
                res[i] = count;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
