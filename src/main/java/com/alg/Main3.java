package com.alg;

import java.util.*;

public class Main3 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int street = sc.nextInt() - 1;
        int checkPoint = sc.nextInt();
        int[] checks = new int[checkPoint];
        for (int i = 0; i < checkPoint; i++) {
            checks[i] = sc.nextInt();
        }
        System.out.println(insertRes(checks, street));
    }


    static int insertRes(int[] report, int street) {
        int start = 0, lower = 0, upper = 0;
        List<Tuple> res = new ArrayList<>();
        start += report[0];
        lower = Math.min(lower, start);
        upper = Math.max(upper, start);
        res.add(new Tuple(lower, upper, start));
        start -= report[0];
        lower = Math.min(lower, start);
        upper = Math.max(upper, start);
        res.add(new Tuple(lower, upper, start));
        for (int i = 1, len = report.length; i < len; i++) {
            List<Tuple> tmp = new ArrayList<>();
            for (Tuple t : res) {
                tmp.add(new Tuple(Math.min(t.lower, t.state - report[i]), Math.max(t.upper, t.state - report[i]), t.state - report[i]));
                tmp.add(new Tuple(Math.min(t.lower, t.state + report[i]), Math.max(t.upper, t.state + report[i]), t.state + report[i]));
            }
            res = tmp;
        }
        Set<Integer> streetRes = new HashSet<>();

        for (Tuple t : res) {
            if (upper - lower > street) {
                continue;
            } else {
                if (lower < 0) {
                    t.upper += (0 - t.lower);
                    t.state += (0 - t.lower);
                    t.lower = 0;
                } else {
                    t.upper -= t.lower;
                    t.state -= t.lower;
                    t.lower = 0;
                }

                int tmp = street - t.upper;
                for (int i = 0; i <= tmp; i++) {
                    streetRes.add(t.state + i);
                }
            }
        }
        return streetRes.size();
    }
}

class Tuple {
    public int lower;
    public int upper;
    public int state;

    public Tuple(int lower, int upper, int state) {
        this.lower = lower;
        this.upper = upper;
        this.state = state;
    }
}