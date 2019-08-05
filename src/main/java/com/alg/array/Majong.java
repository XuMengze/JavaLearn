package com.alg.array;

import java.util.*;


public class Majong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[13];
        for (int i = 0; i < 13; i++) {
            arr[i] = sc.nextInt();
        }
        Majong game = new Majong();
        game.detectHu(arr);
    }


    private void detectHu(int[] arr) {
        if (arr == null || arr.length != 13) {
            System.out.println("Illegal array for mahjong game!");
            return;
        }
        int[] countArr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        List<Hu> possibleHu = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (countArr[i] < 2) {
                continue;
            }
            int[] newArr = new int[countArr.length];
            List<Integer> tings = new ArrayList<>();
            for (int j = 1; j <= 9; j++) {
                System.arraycopy(countArr, 0, newArr, 0, newArr.length);
                newArr[i] -= 2;
                if (j == i && newArr[j] + 1 > 2) {
                    continue;
                } else {
                    if (newArr[j] + 1 > 4) {
                        continue;
                    }
                    newArr[j] += 1;
                }
                if (isABCOrAAAPattern(newArr)) {
                    tings.add(j);
                }
            }

            if (!tings.isEmpty()) {
                Hu newOne = new Hu();
                newOne.jiang = i;
                newOne.tings = tings;
                possibleHu.add(newOne);
            }
        }
        for (int i = 1; i <= 9; i++) {
            int[] newArr = new int[countArr.length];
            List<Integer> tings = new ArrayList<>();
            if (countArr[i] == 1) {
                newArr[i] = 0;
                if (isABCOrAAAPattern(newArr)) {
                    tings.add(i);
                }
            }
            if (!tings.isEmpty()) {
                Hu newOne = new Hu();
                newOne.jiang = i;
                newOne.tings = tings;
                possibleHu.add(newOne);
            }
        }
        if (possibleHu.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(combileOutput(possibleHu));
        }
    }

    private boolean isABCOrAAAPattern(int[] newArr) {
        for (int i = 0; i < newArr.length - 2; i++) {
            while (newArr[i] > 0 && newArr[i] != 3) {
                newArr[i] -= 1;
                if (newArr[i + 1] == 0) {
                    return false;
                } else {
                    newArr[i + 1] -= 1;
                }
                if (newArr[i + 2] == 0) {
                    return false;
                } else {
                    newArr[i + 2] -= 1;
                }
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] != 0 && newArr[i] != 3) {
                return false;
            }
        }
        return true;
    }
    private class Hu {
        private int jiang;
        private List<Integer> tings;
    }


    static String combileOutput(Collection<Hu> cs) {
        String res = "";
        Set<Integer> list = new HashSet<>();
        for (Hu c : cs) {
            for (Integer i : c.tings)
                list.add(i);
        }
        Collections.sort(new ArrayList<>(list));
        for (Integer i : list) {
            res += i + " ";
        }
        return res.substring(0, res.length() - 1);
    }
}