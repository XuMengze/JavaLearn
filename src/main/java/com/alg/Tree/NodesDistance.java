package com.alg.Tree;

import com.alg.model.TreeNode;

public class NodesDistance {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);

        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(1);
        TreeNode h = new TreeNode(1);
        TreeNode i = new TreeNode(1);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        d.left = f;
        f.left = h;
        e.right = g;
        g.right = i;

        getNodesMaxDistance(a);
        System.out.println(maxDis);
    }

    static int maxDis = 0;

    static void getNodesMaxDistance(TreeNode root) {
        if (root == null)
            return;
        if (maxDis < getSumOfLandR(root)) {
            maxDis = getSumOfLandR(root);
        }
        getNodesMaxDistance(root.left);
        getNodesMaxDistance(root.right);


    }

    static int getSumOfLandR(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.right != null) {
            return maxDepth(root.left) + maxDepth(root.right) + 2;
        } else if (root.left == null || root.right == null) {
            return maxDepth(root.left) + maxDepth(root.right);
        } else {
            return maxDepth(root.left) + maxDepth(root.right) + 1;
        }
    }

    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
    }
}
