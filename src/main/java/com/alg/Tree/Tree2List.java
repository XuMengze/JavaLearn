package com.alg.Tree;

import com.alg.model.ListNode;
import com.alg.model.TreeNode;

public class Tree2List {
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

        tree2List(t4);


    }

    static ListNode head, tail;

    public static void tree2List(TreeNode root) {
        if (root == null)
            return;
        tree2List(root.left);

        if (head == null) {
            head = new ListNode(root.val);
            tail = head;
        } else {
            ListNode newListNode = new ListNode(root.val);
            tail.next = newListNode;
            newListNode.prev = tail;
            tail = newListNode;
        }

        tree2List(root.right);
    }

//
//    String Serialize(TreeNode root) {
//
//    }
//
//    TreeNode Deserialize(String str) {
//
//    }
}
