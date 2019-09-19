package com.alg.other;

import java.util.Scanner;

public class Decode2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        sc.nextLine();

        String[] input1 = new String[round];
        String[] input2 = new String[round];
        for (int i = 0; i < round; i++) {
            input1[i] = sc.nextLine();
            input2[i] = sc.nextLine();
        }

        for (int i = 0; i < round; i++) {
            System.out.println(strategy(input1[i], input2[i]));
        }
    }

    static String strategy(String s1, String s2) {
        StringBuilder res1 = new StringBuilder();
        StringBuilder res2 = new StringBuilder();
        String resString = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!s2.contains(s1.charAt(i) + "")) {
                res1.append("d");
                res2.append("d");
            } else {
                if (resString.equals("")) {
                    res1.append("r");
                    res2.append("l");
                    resString += s1.charAt(i);
                } else {
                    int li = s2.indexOf(s1.charAt(i - 1));
                    int former = li - 1;
                    int latter = li + 1;
                    if (0 <= former && s2.charAt(former) == s1.charAt(i)) {
                        res1.append("l");
                        res2.append("l");
                        resString = s1.charAt(i) + resString;
                    } else if (s2.length() > latter && s2.charAt(latter) == s1.charAt(i)) {
                        res1.append("r");
                        res2.append("r");
                        resString = resString + s1.charAt(i);
                    } else {
                        res1.append("d");
                        res2.append("d");
                    }
                }
            }
        }
        if (resString.equals(s2)) {
            String res = "{\n";
            if (res1.compareTo(res2) < 0) {
                res += toS(res1.toString().split("")) + "\n";
                res += toS(res2.toString().split("")) + "\n";
            } else {
                res += toS(res2.toString().split("")) + "\n";
                res += toS(res1.toString().split("")) + "\n";
            }
            res += "}";
            return res;
        } else {
            return "{\n" + "}";
        }
    }

    static String toS(String[] s) {
        StringBuilder sb = new StringBuilder();
        for (String ss : s) {
            sb.append(ss).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

}
