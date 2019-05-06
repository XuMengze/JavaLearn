package com.alg.LinkedList;

import com.alg.model.ListNode;

public class LastNthNode {
    public static void main(String[] args) {
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        ListNode n0 = new ListNode(0);
        n6.next = n5;
        n5.next = n4;
        n4.next = n3;
        n3.next = n2;
        n2.next = n1;
        n1.next = n0;

        ListNode aha = getLastNthNode(n6, 1);
        System.out.println(aha.val);


    }

    public static ListNode getLastNthNode(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
