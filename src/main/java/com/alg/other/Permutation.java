package com.alg.other;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        getPermutation(4);
    }

    public static void getPermutation(int num) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> restList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            restList.add(i);
        }

        for (Integer i : restList) {
            ArrayList<Integer> modiftRestList = (ArrayList<Integer>) restList.clone();
            ArrayList<ArrayList<Integer>> originalList = new ArrayList<>();
            ArrayList<Integer> innerList = new ArrayList<>();
            innerList.add(i);
            originalList.add(innerList);
            modiftRestList.remove(i);
            getPermutationRecursive(originalList, modiftRestList, resultList);
        }
        System.out.println(resultList);
    }

    public static void getPermutationRecursive(ArrayList<ArrayList<Integer>> originalList,
                                               ArrayList<Integer> restList,
                                               ArrayList<ArrayList<Integer>> resultList) {
        if (restList.size() == 0) {
            for (ArrayList<Integer> tmpList : originalList) {
                resultList.add(tmpList);
            }
            return;
        } else {

            for (Integer i : restList) {
                for (ArrayList<Integer> tmpList : originalList) {
                    ArrayList<ArrayList<Integer>> newOriginal = new ArrayList<>();
                    ArrayList<Integer> modifyRestList = (ArrayList<Integer>) restList.clone();
                    ArrayList<Integer> newTmp = (ArrayList<Integer>) tmpList.clone();
                    newTmp.add(i);
                    newOriginal.add(newTmp);
                    modifyRestList.remove(i);
                    getPermutationRecursive(newOriginal, modifyRestList, resultList);
                }
            }
        }
    }
}
