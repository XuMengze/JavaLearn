package com.alg.Tests;

import java.util.*;

public class Huawei2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while (sc.hasNext()) {
            String flag = sc.nextLine();
            if (flag.equals(""))
                break;
            else input.add(flag);
        }
        Set<String> legalList = new LinkedHashSet<>();
        List<String> illegalList = new ArrayList<>();
        Set<String> illegalRotate = new LinkedHashSet<>();
        Set<String> order = new TreeSet<>();
        for (String s : input
        ) {
            if (judgeLegal(s)) {
                legalList.add(s);
                illegalRotate.add(rotate(s));
                order.add(rotate(s));
            } else {
                illegalList.add(s);
            }
        }
        System.out.println(output(legalList));
        System.out.println(output(illegalList));
        System.out.println(output(illegalRotate));
        System.out.println(output(order));
    }

    public static boolean judgeLegal(String s) {
        char[] carr = s.toCharArray();
        for (Character c : carr) {
            if (!((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0') || (c <= 'Z' && c >= 'A'))) {
                return false;
            }
        }
        return true;
    }

    public static String rotate(String s) {
        int index = 10 % s.length();
        return s.substring(index, s.length()) + s.substring(0, index);
    }

    public static String output(Collection c) {
        String res = "";
        for (Object o : c) {
            res += o.toString() + " ";
        }
        return res.substring(0, res.length() - 1);
    }
}
