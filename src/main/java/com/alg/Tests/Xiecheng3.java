package com.alg.Tests;

import java.util.*;

public class Xiecheng3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String path = sc.nextLine().trim();
        path = path.replaceAll(" +", " ");
        String[] pathList = path.split(" ");
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < pathList.length; i++) {
            if (pathList[i].charAt(pathList[i].length() - 1) == '/') {
                pathList[i] = pathList[i].substring(0, pathList[i].length() - 1);
            }
        }
        for (int i = 0; i < pathList.length; i++) {
            int same = 1;
            for (int j = 0; j < i; j++) {
                if (pathList[i].equals(pathList[j]))
                    same++;

            }
            StringBuilder sb = new StringBuilder();
            int segment = pathList[i].split("/").length - 1;
            sb.append("1");
            for (int j = 0; j < segment - 2; j++) {
                sb.append(same + "");
            }
            if (segment > 1) {
                sb.append("1");
            }
            resList.add(sb.toString());
        }

        System.out.println(getRes(resList));
    }

    public static String getRes(Collection c) {
        String res = "";
        for (Object o : c
        ) {
            res = res + o.toString() + " ";
        }
        return res.substring(0, res.length() - 1);
    }

}
