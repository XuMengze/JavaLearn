package com.alg.Tree;

import com.alg.model.TreeNode;

public class LowestCommonAncester {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        a.left = b;
        a.right = null;
        b.left = d;
        b.right = e;
        e.right = f;

        System.out.println(LCASearchTree(a, 2, 4).val);
    }

    static TreeNode LCASearchTree(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        if (!(hasEle(root, node1) && hasEle(root, node2))) {
            return null;
        }

        if (root.val < node2 && root.val > node1) {
            return root;
        } else if (root.val < node2 && root.val < node1) {
            return LCASearchTree(root.right, node1, node2);
        } else {
            return LCASearchTree(root.left, node1, node2);

        }
    }

    static TreeNode LCA(TreeNode root, int node1, int node2) {
        TreeNode leftFlag = null;
        TreeNode rightFlag = null;
        if (null == root)
            return null;
        if (root.val == node1 || node2 == root.val)
            return root;
        leftFlag = LCA(root.left, node1, node2);
        rightFlag = LCA(root.right, node1, node2);
        if (leftFlag != null && rightFlag != null)
            return root;
        else if (leftFlag != null)
            return leftFlag;
            //LCA(root->left, node1, node2);
        else if (rightFlag != null)
            return rightFlag;
            //LCA(root->right, node1, node2);
        else return null;
    }

    static boolean hasEle(TreeNode root, int node) {
        if (root == null) {
            return false;
        } else if (root.val != node) {
            return hasEle(root.left, node) || hasEle(root.right, node);
        } else {
            return true;
        }
    }
}
