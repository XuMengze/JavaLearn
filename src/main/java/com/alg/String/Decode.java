package com.alg.String;

import java.util.*;

public class Decode {
    static List<String> res = new ArrayList<>();

    static Map<String, String> map = new HashMap<>() {{
        put("1", "A");
        put("2", "B");
        put("3", "C");
        put("4", "D");
        put("5", "E");
        put("6", "F");
        put("7", "G");
        put("8", "H");
        put("9", "I");
        put("10", "G");
        put("11", "K");
        put("12", "L");
        put("13", "M");
        put("14", "N");
        put("15", "O");
        put("16", "P");
        put("17", "Q");
        put("18", "R");
        put("19", "S");
        put("20", "T");
        put("21", "U");
        put("22", "V");
        put("23", "W");
        put("24", "X");
        put("25", "Y");
        put("26", "Z");
    }};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        fun(s);
        Collections.sort(res);
        for (String ss : res) {
            System.out.println(ss);
        }
    }

    static void fun(String s) {
        recur(s, "", 0);
    }

    static void recur(String s, String resStr, int index) {
        if (index == s.length()) {
            res.add(resStr);
        } else {
            if (index == s.length() - 1) {
                recur(s, resStr + map.get(s.substring(index, index + 1)), index + 1);
            } else {
                int mid = Integer.parseInt(s.substring(index + 1, index + 2));
                if (s.substring(index, index + 1).equals("1") || (s.substring(index, index + 1).equals("2") && mid <= 6)) {
                    recur(s, resStr + map.get(s.substring(index, index + 1)), index + 1);
                    recur(s, resStr + map.get(s.substring(index, index + 2)), index + 2);
                }
            }
        }
    }
}
