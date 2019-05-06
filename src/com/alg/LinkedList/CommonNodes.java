package com.alg.LinkedList;

import com.alg.model.ListNode;

public class CommonNodes {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;

        ListNode n4 = new ListNode(100);
        n4.next = n1;

        System.out.println(hasCircle(n4));
    }

    public boolean hasCommonNodesWithoutCircle(ListNode LN1, ListNode LN2) {
        if (LN1 == null || LN2 == null) {
            return false;
        } else {
            ListNode LN1Tail = LN1, LN2Tail = LN2;
            while (LN1Tail.next != null) {
                LN1Tail = LN1Tail.next;
            }
            while (LN2Tail.next != null) {
                LN2Tail = LN2Tail.next;
            }
            return LN1Tail == LN2Tail;
        }
    }

    public static boolean hasCircle(ListNode LN) {
        if (LN == null || LN.next == null || LN.next.next == null) {
            return false;
        }
        ListNode slow = LN, fast = LN;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
