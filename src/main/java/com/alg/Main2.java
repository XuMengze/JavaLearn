package com.alg;

import java.util.*;

public class Main2 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String Str = sc.nextLine();
        char[] StrArr = Str.toCharArray();

        Map<Character, Integer> map = MapFunction(StrArr);
        int ch = FindMapMaxValue(map);
        System.out.println(ch);
    }


    public static Map<Character, Integer> MapFunction(char[] StrArr) {
        Map<Character, Integer> map = new HashMap<>();
        if (!(StrArr == null || StrArr.length == 0))
            for (int i = 0; i < StrArr.length; i++)
                if (null != map.get(StrArr[i]))
                    map.put(StrArr[i], map.get(StrArr[i]) + 1);
                else
                    map.put(StrArr[i], 1);

        return map;
    }

    public static int FindMapMaxValue(Map<Character, Integer> map) {
        Set<Character> keys = map.keySet();
        Iterator keys_Itera = keys.iterator();
        Character maxKey = (Character) keys_Itera.next();
        int maxValue = map.get(maxKey);

        while (keys_Itera.hasNext()) {
            Character temp = (Character) keys_Itera.next();
            if (maxValue < map.get(temp)) {
                maxKey = temp;
                maxValue = map.get(temp);
            }
        }
//        System.out.println("出现次数最多的字符：" + maxKey + " 出现次数：" + maxValue);
        return maxValue;
    }
}
