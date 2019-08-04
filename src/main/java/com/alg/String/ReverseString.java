package com.alg.String;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reStr("abcde"));
    }

    public static String reStr(String s) {
        char[] strCH = s.toCharArray();
        for (int i = 0, j = strCH.length - 1; i < j; i++, j--) {
            strCH[i] = (char) (strCH[i] ^ strCH[j]);
            strCH[j] = (char) (strCH[i] ^ strCH[j]);
            strCH[i] = (char) (strCH[i] ^ strCH[j]);
        }
        return new String(strCH);
    }
}
