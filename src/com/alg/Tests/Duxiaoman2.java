package com.alg.Tests;

public class Duxiaoman2 {


    public static void main(String[] args) {
        int ans = 0;
        String s = "xxxy";
        while (s.contains("xy")) {
            StringBuilder sBuilder = new StringBuilder();
            int xyIndex = s.indexOf("xy");
            int latter_y = 0;
            int fommer_x = 0;
            for (int i = xyIndex + 2; i < s.length(); i++) {
                if (s.charAt(i) == 'y') {
                    latter_y++;
                }
            }
            for (int i = xyIndex - 1; i >= 0; i--) {
                if (s.charAt(i) == 'x') {
                    fommer_x++;
                }
            }
            int linshi_ans = latter_y + (int) (Math.pow(2, (fommer_x + 1)) - 1);
            ans = (ans + linshi_ans) % (1000000007);
            sBuilder.append(s.substring(0, xyIndex - fommer_x));

            for (int i = 0; i < linshi_ans + 1; i++) {
                sBuilder.append("y");
            }
            for (int i = 0; i < fommer_x + 1; i++) {
                sBuilder.append("x");
            }
            sBuilder.append(s.substring(xyIndex + latter_y + 2, s.length()));
            s = sBuilder.toString();
        }
        System.out.println(ans);
    }
}
