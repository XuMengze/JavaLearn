package com.alg.other;

public class NDigitNumber {
    public static final int DIGITS = 5;

    public static void main(String[] args) {
        String num = "";
        for (int i = 0; i < DIGITS; i++) {
            num += "9";
        }
        for (String i = "1"; StringNumBiggerThan(num, i); i = StringApppendOne(i)) {
            System.out.println(i);
        }
    }

    static boolean StringNumBiggerThan(String n1, String n2) {
        if (n1.length() > n2.length())
            return true;
        else if (n1.length() < n2.length()) {
            return false;
        } else {
            return n1.compareTo(n2) >= 0 ? true : false;
        }
    }

    static String StringApppendOne(String s) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = builder.length() - 1; i >= 0; i--) {
            if (builder.charAt(i) == '9') {
                builder.setCharAt(i, '0');
            } else {
                builder.setCharAt(i, (char) (builder.charAt(i) + 1));
                break;
            }
        }
        if (builder.charAt(0) == '0') {
            return "1" + builder.toString();
        } else {
            return builder.toString();
        }
    }
}
