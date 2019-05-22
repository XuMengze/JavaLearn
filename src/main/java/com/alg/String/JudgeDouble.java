package com.alg.String;

public class JudgeDouble {
    public static void main(String[] args) {
        System.out.println(10==10L);
    }

    public static boolean judge(String s) {
        if (s.matches("[0-9]+")) {
            return true;
        }
        return false;
    }
}
