package com.alg.array;

import java.util.Collections;
import java.util.Scanner;

public class ArrReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] inputSplit = input.split(" ");

        int i = 0, j = inputSplit.length - 1;
        while (i < j) {
            String tmp = inputSplit[i];
            inputSplit[i] = inputSplit[j];
            inputSplit[j] = tmp;
            i++;
            j--;
        }
        System.out.println(String.join(" ", inputSplit));
    }
}
