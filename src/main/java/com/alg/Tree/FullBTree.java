package com.alg.Tree;

import com.alg.model.TreeNode;

public class FullBTree {
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    static boolean justifyComplete(TreeNode root) {
        if (root == null) {
            return false;
        }
        TreeNode toLeft = root, toRight = root;
        int leftCount = 1, rightCount = 1;


        while (toLeft.left != null) {
            toLeft = toLeft.left;
            leftCount++;
        }

        while (toRight.right != null) {
            toRight = toRight.right;
            rightCount++;
        }

        return leftCount == rightCount;
    }

    static int heightComplete(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        while (root.left != null) {
            root = root.left;
            height++;
        }
        return height;
    }
}
