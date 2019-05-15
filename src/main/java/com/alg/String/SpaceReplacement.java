package com.alg.String;

public class SpaceReplacement {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happpy")));
    }

    public static String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "20%");
    }
}
