package com.alg.Tests;

import com.alg.model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tencent {

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode root1 = new TreeNode(2);
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root3 = new TreeNode(3);
//        TreeNode root4 = new TreeNode(3);
//        TreeNode root5 = new TreeNode(4);
//        root.left = root1;
//        root.right = root3;
//        root1.left = root5;
//        root3.left = root2;
//        root3.right = root4;
//
//
//        System.out.println(ExistPath(root, 6));
//    }


    public static void main(String[] args) {

    }

    public static int getSolutionNums(int k, int m, int a, int n, int b) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = k; j >= a; j--) {
                dp[j] = (dp[j] + dp[j - a]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= b; j--) {
                dp[j] = (dp[j] + dp[j - b]);
            }
        }
        return dp[k];
    }

//    public class com.alg.Tests.Xiecheng.Solution {
//        private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
//        private ArrayList<Integer> list = new ArrayList<Integer>();
//
//        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//            if (root == null) return listAll;
//            list.add(root.val);
//            target -= root.val;
//            if (target == 0 && root.left == null && root.right == null) listAll.add(new ArrayList<Integer>(list));
//            FindPath(root.left, target);
//            FindPath(root.right, target);
//            list.remove(list.size() - 1);
//            return listAll;
//        }
//    }

    public boolean ExistPath(TreeNode root, int target) {
        if (root == null && target != 0) {
            return false;
        }
        if (target == root.val && root.left == null && root.right == null) {
            return true;
        } else {
            return ExistPath(root.left, target - root.val) || ExistPath(root.right, target - root.val);
        }
    }

    public String replaceChar(String a, String b) {
        char[] replaceChar = b.toCharArray();
        Set<Character> s = new HashSet();
        for (Character c : replaceChar) {
            s.add(c);
        }
        for (Character c : s) {
            a = a.replace(c + "", "");
        }
        return a;
    }

    public static boolean matchPlate(String a, String b) {
        char[] barr = b.toCharArray();
        char[] aarr = a.toCharArray();
        int index = 0;
        int i;
        for (i = 0; i < barr.length; i++) {
            while (index < aarr.length && barr[i] != aarr[index]) {
                index++;
            }
        }
        if (index < aarr.length) {
            return true;
        } else {
            return false;
        }
    }
}
