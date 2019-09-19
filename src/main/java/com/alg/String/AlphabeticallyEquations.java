package com.alg.String;

import java.util.Scanner;

public class AlphabeticallyEquations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arrlen = len * 2 - 1;
        String s = sc.nextLine();
        s = sc.nextLine();
        String[] equation = s.split(" ");
        if (equation.length <= 1) {
            System.out.println(arrToString(equation));
            return;
        }
        if (equation.length == 3) {
            if (equation[1].equals("*") || equation[1].equals("+")) {
                if (Integer.parseInt(equation[0]) > Integer.parseInt(equation[2])) {
                    swap(equation, 0, 2);
                }
            }
            System.out.println(arrToString(equation));
            return;
        }

        boolean exch;
        do {
            exch = false;
            for (int i = 1; i <= arrlen - 1; i += 2) {
                if (Integer.parseInt(equation[i - 1]) < Integer.parseInt(equation[i + 1])) {
                    continue;
                }
                if (i == 1 && equation[i].equals("+") && i + 2 <= arrlen - 1 && (equation[i + 2].equals("+") || equation[i + 2].equals("-"))) {
                    swap(equation, i - 1, i + 1);
                    exch = true;
                } else if (i == 1 && equation[i].equals("*")) {
                    swap(equation, i - 1, i + 1);
                    exch = true;
                } else if (i == arrlen - 2 && equation[i].equals("+") && i - 2 >= 1 && equation[i - 2].equals("+")) {
                    swap(equation, i - 1, i + 1);
                    exch = true;
                } else if (i == arrlen - 2 && equation[i].equals("*") && i - 2 >= 1 && !equation[i - 2].equals("/")) {
                    swap(equation, i - 1, i + 1);
                    exch = true;
                } else if (equation[i].equals("+") && equation[i - 2].equals("+") && (equation[i + 2].equals("+") || equation[i + 2].equals("-"))) {
                    swap(equation, i - 1, i + 1);
                    exch = true;
                } else if (equation[i].equals("*") && !equation[i - 2].equals("/")) {
                    swap(equation, i - 1, i + 1);
                    exch = true;
                }
            }
        } while (exch);

        System.out.println(arrToString(equation));
    }

    static void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static String arrToString(String[] s) {
        StringBuilder sb = new StringBuilder("");
        for (String single : s) {
            sb.append(single);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
