package com.alg.Tree;

import com.alg.model.TreeNode;

public class ConstructBST {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = array2Tree(A);
        System.out.println(root.left.val);
    }

    static TreeNode array2Tree(int[] array) {
        return helper(array, 0, array.length - 1);
    }

    static TreeNode helper(int[] array, int start, int end) {
        if (start > end) return null;
        int m = start + (end - start) / 2;
        TreeNode root = new TreeNode(array[m]);
        root.left = helper(array, start, m - 1);
        root.right = helper(array, m + 1, end);
        return root;
    }
}
