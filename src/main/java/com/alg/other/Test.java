package com.alg.other;

public class Test {
    public static void main(String[] args) {
        String s = "12345678910111213141516171819202122232425" +
                "26272829303132333435363738394041424344454647484950" +
                "51525354555657585960616263646566676869707172737475" +
                "767778798081828384858687888990919293949596979899100" +
                "101102103";
        StringBuilder res = new StringBuilder(s.substring(0, 1));
        res.append(",");
        int step = 1;
        int start = 1;
        int last = Integer.parseInt(s.substring(0, 1));
        while (start < s.length()) {
            if (Integer.parseInt(s.substring(start, step + start)) < last) {
                step++;
            }
            last = Integer.parseInt(s.substring(start, step + start));
            res.append(last);
            res.append(",");
            start += step;
        }
        String result = res.toString().substring(0, res.length() - 1);
        System.out.println(result);
    }
}
