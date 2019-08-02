package com.alg.LinkedList;

import com.alg.model.ListNode;

public class ReversePrint {
    public static void main(String[] args) {

        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        ListNode n0 = new ListNode(0);


        n0.next = n1;

        printList(n0);

        ListNode tmp = n0.next;
        n0.next = n2;
        n2.next = tmp;


        System.out.println();
        printList(n0);


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
