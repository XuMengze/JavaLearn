package com.alg.Tests;

import java.util.*;

public class Huawei {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        int num = 4;
        List<String[]> arrlist = new ArrayList();
//        while (sc.hasNext()) {
//            arrlist.add(sc.nextLine().split(","));
//        }
        String[] arr1 = {"2", "5", "6", "7", "9", "5", "7"};
        String[] arr2 = {"1", "7", "4", "3", "4"};
        arrlist.add(arr1);
        arrlist.add(arr2);

        List<String> res = new ArrayList();
        while (arrlist.size() > 0) {
            for (int i = 0; i < arrlist.size(); i++) {
                if (num <= arrlist.get(i).length) {
                    for (int j = 0; j < num; j++) {
                        res.add(arrlist.get(i)[j]);
                    }
                    String[] new_arr = Arrays.copyOfRange(arrlist.get(i), num, arrlist.get(i).length);
                    arrlist.remove(arrlist.get(i));
                    arrlist.add(i, new_arr);
                } else {
                    for (int j = 0; j < arrlist.get(i).length; j++) {
                        res.add(arrlist.get(i)[j]);
                    }
                    arrlist.remove(arrlist.get(i));
                }
            }
        }

        System.out.println(output(res));
    }

    public static String output(Collection c) {
        String res = "";
        for (Object o : c) {
            res += o.toString() + ",";
        }
        return res.substring(0, res.length() - 1);
    }
}
