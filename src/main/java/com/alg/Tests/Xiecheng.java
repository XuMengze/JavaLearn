package com.alg.Tests;

import java.util.*;

public class Xiecheng {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        String[] strarr = list.split(",");
        Set<String> middleSet = new HashSet<>();
        for (String s :
                strarr) {
            middleSet.add(s);
        }
        System.out.println(!(strarr.length == middleSet.size()));
    }

}
