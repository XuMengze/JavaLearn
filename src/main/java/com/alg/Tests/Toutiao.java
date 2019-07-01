package com.alg.Tests;


import java.util.Scanner;

public class Toutiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] years = new String[1];
        for (int i = 0; i < num; i++) {
            years[i] = sc.next();
        }
        for (String year : years) {
            if (year.split("-")[1].equals("02") && year.split("-")[0].equals("29") && isLeapYear(Integer.parseInt(year.split("-")[0]) + 18)) {
                System.out.println(-1);
            }else{
                System.out.println(366 * LeapYearNum(Integer.parseInt(year.split("-")[0])) + 365 * (18 - LeapYearNum(Integer.parseInt(year.split("-")[0]))));
            }
        }
    }

    public static int LeapYearNum(int year) {
        int num = 0;
        for (int i = 0; i < 18; i++) {
            if (isLeapYear(year + i)) {
                num++;
            }
        }
        return num;
    }

    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if (year % 4 == 0 && year % 100 != 0) {
            isLeap = true;
        } else if (year % 400 == 0) {
            isLeap = true;
        }
        return isLeap;
    }
}
