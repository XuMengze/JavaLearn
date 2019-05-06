package com.alg.Tree;

import com.alg.model.TreeNode;

import java.lang.reflect.Method;

public class SpecificSumPath {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(12);
        TreeNode t5 = new TreeNode(7);
        t1.left = t3;
        t3.left = t2;
        t1.right = t4;
        t3.right = t5;

        findPath(t1, 22);

    }

    public static void findPath(TreeNode root, int total) {
        if (root == null)
            return;
        if (root.val < total) {
            findPath(root.left, total - root.val);
            findPath(root.right, total - root.val);
        } else if (root.val == total) {
            System.out.println(root.val);
        }
    }

}
