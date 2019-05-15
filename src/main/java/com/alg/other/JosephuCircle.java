package com.alg.other;

import java.util.ArrayList;
import java.util.List;

public class JosephuCircle {

    public static void josephuCircle(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);

        }
        //从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;

            } else {
                System.out.println(start.get(k));
                start.remove(k);

            }
        }
    }
}
