package com.alg.String;

public class CompressString {
    public static void main(String[] args) {
        String res = "aabbcc";
        System.out.println(compress(res));
    }

    static String compress(String src) {
        String res = "";
        res += src.charAt(0);
        res += 1;
        for (int i = 1; i < src.length(); i++) {
            if (src.charAt(i) == res.charAt(res.length() - 2)) {
                res = res.substring(0, res.length() - 1) + (Integer.parseInt(res.charAt(res.length() - 1) + "") + 1);
            } else {
                res = res + src.charAt(i) + 1;
            }
        }
        if (res.length() < src.length())
            return res;
        else
            return src;
    }
}
