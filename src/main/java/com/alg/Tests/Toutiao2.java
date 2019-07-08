package com.alg.Tests;


import java.util.Scanner;
import java.util.regex.Pattern;

public class Toutiao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        String pattern = sc.nextLine();
        if (pattern.equals("")) {
            if (src.equals("")) {
                System.out.println("true");
                return;
            } else {
                System.out.println("false");
                return;
            }
        }

        Pattern p = Pattern.compile(pattern);
        System.out.println(p.matcher(src).matches());

    }
}
