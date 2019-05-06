package com.alg.Tree;

import com.alg.model.TreeNode;

public class MinDepth {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = null;
        b.left = d;
        b.right = e;
        e.right = f;

        int minDepth = minDepth(a);
        System.out.println(minDepth);
    }

    static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
        }
    }
}
