package com.alg.array;

import java.util.*;

public class CoupleBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String charSet = sc.nextLine();
        String inputString = sc.nextLine();
        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0, len = charSet.length(); i < len - 1; i += 2) {
            charMap.put(charSet.charAt(i), charSet.charAt(i + 1));
        }
        System.out.println(justify(charMap, inputString));

    }

    private static boolean justify(Map<Character, Character> charMap, String input) {
        if (input == null || input.equals("")) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = input.length(); i < len; i++) {
            if (charMap.get(input.charAt(i)) != null) {
                stack.push(charMap.get(input.charAt(i)));
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                Character c = stack.pop();
                if (c != input.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}