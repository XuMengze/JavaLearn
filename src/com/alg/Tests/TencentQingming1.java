package com.alg.Tests;

import java.util.*;

public class TencentQingming1 {

    public static void main(String[] args) {
        int total;
        int num;
        Scanner sc = new Scanner(System.in);
        total = sc.nextInt();
        num = sc.nextInt();

        int[] money = new int[num];

        for (int i = 0; i < num; i++) {
            money[i] = sc.nextInt();
        }

        System.out.println(getMinCoinCounts(money, total));
    }

    public static int getMinCoinCounts(int coinValue[], int money) {
        Arrays.sort(coinValue);
        Map<Integer, Integer> resmap = new HashMap<>();
        if (coinValue[0] != 1) {
            return -1;
        }
        resmap.put(1, 1);
        int[] num = new int[money + 1];
        num[0] = 0;
        num[1] = 1;

        List<Map> arrList = new ArrayList();
        arrList.add(0, null);
        arrList.add(1, (HashMap) ((HashMap) resmap).clone());

        for (int i = 2; i <= money; i++) {
            int value = 0;
            for (Integer in : coinValue) {
                int min = 1000000;
                if (in <= i) {
                    if (num[i - in] + 1 < min) {
                        value = in;
                        num[i] = num[i - in] + 1;
                    }
                }
            }
            Map map = arrList.get(i - value);
            if (map == null) {
                Map mapput = new HashMap();
                mapput.put(value, 1);
                arrList.add(mapput);

                if (resmap.get(value) == null) {
                    resmap.put(value, 1);
                }
            } else {
                Map mapput = (HashMap) ((HashMap) map).clone();
                if (mapput.get(value) == null) {
                    mapput.put(value, 1);
                } else {
                    mapput.put(value, (int) mapput.get(value) + 1);
                }
                arrList.add(mapput);

                Iterator<Map.Entry<Integer, Integer>> it = mapput.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    if (resmap.get(entry.getKey()) == null) {
                        resmap.put(entry.getKey(), entry.getValue());
                    } else {
                        resmap.put(entry.getKey(), Math.max(entry.getValue(), resmap.get(entry.getKey())));
                    }
                }
            }
        }
        int resnum = 0;
        Iterator<Map.Entry<Integer, Integer>> it = resmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            resnum += entry.getValue();
        }
        return resnum;
    }
}


//
//import java.util.Scanner;
//
//public class Main {
//
//    static int curWuli = 0;
//    static int[] celue;
//    static int[] wuli;
//    static int[] huilu;
//    static int n;
//    static int minHuilu = Integer.MAX_VALUE;
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n = Integer.parseInt(in.nextLine());
//
//        wuli = new int[n];
//        huilu = new int[n];
//        for (int i = 0; i < wuli.length; i++) {
//            wuli[i] = in.nextInt();
//
//        }
//        for (int i = 0; i < huilu.length; i++) {
//            huilu[i] = in.nextInt();
//        }
//
//        celue = new int[n];
//        huisu(0);
//
//        System.out.println(minHuilu);
//    }
//
//    public static boolean huisu(int i) {
//        if (wuli[i] <= curWuli) {
//            if (i == n - 1) {
//                int sum = 0;
//                for (int j = 0; j < celue.length; j++) {
//                    sum += celue[j] == 1 ? huilu[j] : 0;
//                }
//                minHuilu = Math.min(minHuilu, sum);
//
//                return true;
//            }
//            if (!huisu(i + 1)) {
//                celue[i] = 1;
//                curWuli += wuli[i];
//                boolean flag = huisu(i + 1);
//                celue[i] = 0;
//                curWuli -= wuli[i];
//                return flag;
//            } else {
//
//                celue[i] = 1;
//                curWuli += wuli[i];
//                boolean flag = huisu(i + 1);
//                celue[i] = 0;
//                curWuli -= wuli[i];
//                return flag;
//            }
//        } else {
//            celue[i] = 1;
//            curWuli += wuli[i];
//            if (i == n - 1) {
//                int sum = 0;
//                for (int j = 0; j < celue.length; j++) {
//                    sum += celue[j] == 1 ? huilu[j] : 0;
//                }
//                minHuilu = Math.min(minHuilu, sum);
//                celue[i] = 0;
//                curWuli -= wuli[i];
//                return true;
//            }
//            boolean flag = huisu(i + 1);
//            celue[i] = 0;
//            curWuli -= wuli[i];
//            return flag;
//        }
//    }
//}
