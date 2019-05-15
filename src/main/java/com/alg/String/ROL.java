package com.alg.String;

public class ROL {
    public static void main(String[] args) {
        String in = "abcdefghi";
        System.out.println(solution(in, 3));
    }

    public static String solution(String input, int n) {
        if (n < 1)
            return input;
        if (input.equals(""))
            return input;
        char[] inCharArr = input.toCharArray();
        reverseCharArr(inCharArr, 0, n - 1);
        reverseCharArr(inCharArr, n, inCharArr.length - 1);
        reverseCharArr(inCharArr, 0, inCharArr.length - 1);
        return new String(inCharArr);
    }

    public static void reverseCharArr(char[] charArr, int begin, int end) {
        for (int i = begin, j = end; i <= (begin + end) / 2 && i < j; i++, j--) {
            char tmp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = tmp;
        }
    }

}
