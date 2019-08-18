package com.alg.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch {
    public static void main(String[] args) {
        // HG[3|B[2|CA]]F -> HGBCACABCACABCACAF
        String input = "HG[3|B[2|CA]]F";
        Pattern p = Pattern.compile("\\[\\d+\\|[A-Z]+]");
        String res = input;

        for (int i = 0; i < 10000; i++) {
            Matcher matcher = p.matcher(res);
            if (matcher.matches()) {
                break;
            }
            while (matcher.find()) {
                String result = matcher.group();
                res = res.replace(result, getString(result));
            }
        }
        System.out.println(res);
    }

    public static String getString(String s) {
        String[] arr = s.split("\\|");
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = Integer.parseInt(arr[0].substring(1)); i < len; i++) {
            sb.append(arr[1].substring(0, arr[1].length() - 1));
        }
        return sb.toString();
    }
}
