package com.alg.LinkedList;

import com.alg.model.ListNode;

public class ReversePrint {
    public static void main(String[] args) {

        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        ListNode n0 = new ListNode(0);


        n0.next = n1;
        n1.next = n2;


        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        n2.next = n3;

        n3.next = n4;
        n4.next = n5;

        reversePrint(n0);
    }

    static void reversePrint(ListNode head) {
        while (head != null) {
            reversePrint(head.next);
            System.out.println(head.val);
            break;
        }
    }

    public static void printList(ListNode head) {
        ListNode ptr = null;
        if (head != null) {
            ptr = head;
        }
        while (ptr != null) {
            System.out.print(ptr.val + "-->");
            ptr = ptr.next;
        }
        System.out.println();

    }
}
