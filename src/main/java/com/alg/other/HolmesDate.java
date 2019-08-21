package com.alg.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HolmesDate {
    static final Map<Character, String> weekMap = new HashMap<>(7) {{
        put('A', "MON");
        put('B', "TUE");
        put('C', "WED");
        put('D', "THU");
        put('E', "FRI");
        put('F', "SAT");
        put('G', "SUN");
    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] firstLine = sc.nextLine().toCharArray();
        char[] secondLine = sc.nextLine().toCharArray();
        char[] thirdLine = sc.nextLine().toCharArray();
        char[] fourthLine = sc.nextLine().toCharArray();

        int firstIndex = -1;
        int secondIndex = -1;
        int thirdIndex = -1;

        for (int i = 0, len = Math.min(firstLine.length, secondLine.length); i < len; i++) {
            if (firstLine[i] == secondLine[i]) {
                if (firstIndex == -1) {
                    if (firstLine[i] <= 'Z' && firstLine[i] >= 'A') {
                        firstIndex = i;
                    }
                    continue;
                }
                secondIndex = i;
                break;
            }
        }

        for (int i = 0, len = Math.min(thirdLine.length, fourthLine.length); i < len; i++) {
            if (thirdLine[i] == fourthLine[i] && thirdLine[i] >= 'A' && thirdLine[i] <= 'z') {
                thirdIndex = i;
                break;
            }
        }

        System.out.println(weekMap.get(firstLine[firstIndex]) + " "
                + (firstLine[secondIndex] - 'A' > 0 ? firstLine[secondIndex] - 'A' + 10 : "0" + (firstLine[secondIndex] - '0'))
                + ":" + (thirdIndex < 10 ? "0" + thirdIndex : thirdIndex));
    }
}
