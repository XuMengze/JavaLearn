package com.alg.other;

import java.util.Stack;

public class ValidParenthese {
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        char[] input = s.toCharArray();
        Stack<Character> parantheseStack = new Stack<>();
        for (char c : input) {
            if (isLeft(c)) {
                parantheseStack.push(c);
            } else {
                if (!isPair(parantheseStack.pop(), c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLeft(char s) {
        if (s == '(' || s == '[' || s == '{') {
            return true;
        } else if (s == ')' || s == ']' || s == '}') {
            return false;
        } else {
            throw new RuntimeException("CNM");
        }
    }

    public static boolean isPair(char c1, char c2) {
        if ((c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')')) {
            return true;
        } else {
            return false;
        }
    }
}
