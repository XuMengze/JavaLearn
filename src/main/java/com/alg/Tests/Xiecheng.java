package com.alg.Tests;

import java.util.*;

public class Xiecheng {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        String[] strarr = list.split(",");
        Set<String> middleSet = new HashSet<>();
        for (String s :
                strarr) {
            middleSet.add(s);
        }
        System.out.println(!(strarr.length == middleSet.size()));
    }

    public static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
    //        String s = "alibaba 2019,youku 2020, alibaba 2021";
            String s = "abcabca";
            List<String> res = solution.mostOccuranceSmart(s);
            System.out.println(res.toString());
        }

        public List<String> mostOccurance(String inputStr) {
            int max = -1;
            Map<String, Integer> subStrMap = new HashMap<>();
            for (int i = 2, len = inputStr.length(); i <= len; i++) {
                for (int j = 0; j <= len - i; j++) {
                    if (subStrMap.get(inputStr.substring(j, j + i)) == null) {
                        subStrMap.put(inputStr.substring(j, j + i), 1);
                        if (1 > max) {
                            max = 1;
                        }
                    } else {
                        subStrMap.put(inputStr.substring(j, j + i), subStrMap.get(inputStr.substring(j, j + i)) + 1);
                        if (subStrMap.get(inputStr.substring(j, j + i)) + 1 > max) {
                            max = subStrMap.get(inputStr.substring(j, j + i));
                        }
                    }
                }
            }
            List<String> resList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : subStrMap.entrySet()) {
                if (entry.getValue() == max) {
                    resList.add(entry.getKey());
                }
            }
            return resList;
        }

        //减少了搜索空间
        public List<String> mostOccuranceSmart(String inputStr) {
            Map<String, Integer> subStrMap = new HashMap<>();
            Map<String, List<Integer>> subStrPosMap = new HashMap<>();
            int max = -1, i = 2, len = inputStr.length();

            //开始只遍历一遍，只找出长度为2的字串并统计数量。
            for (int j = 0; j <= len - i; j++) {
                if (subStrMap.get(inputStr.substring(j, j + i)) == null) {
                    subStrMap.put(inputStr.substring(j, j + i), 1);
                    if (1 > max) {
                        max = 1;
                    }
                    List<Integer> posList = new ArrayList<Integer>();
                    posList.add(j + i - 1);
                    subStrPosMap.put(inputStr.substring(j, j + i), posList);
                } else {
                    subStrMap.put(inputStr.substring(j, j + i), subStrMap.get(inputStr.substring(j, j + i)) + 1);
                    if (subStrMap.get(inputStr.substring(j, j + i)) + 1 > max) {
                        max = subStrMap.get(inputStr.substring(j, j + i));
                    }
                    subStrPosMap.get(inputStr.substring(j, j + i)).add(j + i - 1);
                }
            }
            List<String> resList = new ArrayList<>();
            //最多的只可能是长度为2的字串最多的，可能还会后续加上几个字符也是最多的，比如上面第二个例子，第一遍扫描ss是最多的，加上后面的o变为sso也是最多的
            for (Map.Entry<String, Integer> entry : subStrMap.entrySet()) {
                if (entry.getValue() == max) {
                    //长度为2的最多的肯定是结果之一，直接加进去
                    resList.add(entry.getKey());
                    List<Integer> list = subStrPosMap.get(entry.getKey());
                    while (true) {
                        //如果到底，直接退出，肯定长度为2的字串最多
                        if (list.get(list.size() - 1) == inputStr.length() - 1) {
                            break;
                        }
                        //如果没到底，对每一个位置的下一个位置的字符判断，都一样，那么结果中加一个，这个长度为3的字串出现次数也最多
                        Set<Character> setCheckDuplicate = new HashSet<>();
                        for (Integer index : list) {
                            setCheckDuplicate.add(inputStr.charAt(index + 1));
                        }
                        //一样的话，位置数组都加1，继续往后面看
                        if (setCheckDuplicate.size() == 1) {
                            resList.add(entry.getKey() + inputStr.charAt(list.get(0) + 1) + "");
                            ListIterator<Integer> it = list.listIterator();
                            while (it.hasNext()) {
                                it.set(it.next() + 1);
                            }
                        }
                        //不一样的话，直接退出，不会有出现次数多于目前长度的字串
                        else {
                            break;
                        }
                    }
                }
            }
            return resList;
        }
    }
}
