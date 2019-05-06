package com.alg.Tree;

import com.alg.model.TreeNode;

public class MirrorTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(10);
        TreeNode t5 = new TreeNode(12);
        TreeNode t6 = new TreeNode(14);
        TreeNode t7 = new TreeNode(16);

        t4.left = t2;
        t4.right = t6;

        t2.left = t1;
        t2.right = t3;

        t6.left = t5;
        t6.right = t7;

        mirrorTree(t4);
        midOrder(t4);


    }

    public static TreeNode mirrorTree(TreeNode root) {

        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }

    public static void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            System.out.println(root.val);
            midOrder(root.right);
        } else {
            return;
        }
    }

    public static void levelOrder(TreeNode root) {

    }
}
