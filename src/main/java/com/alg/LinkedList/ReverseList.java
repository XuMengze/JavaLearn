package com.alg.LinkedList;

import com.alg.model.ListNode;

import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
//        ListNode n6 = new ListNode(6);
//        ListNode n5 = new ListNode(5);
//        ListNode n4 = new ListNode(4);
//        ListNode n3 = new ListNode(3);
//        ListNode n2 = new ListNode(2);
//        ListNode n1 = new ListNode(1);
//        ListNode n0 = new ListNode(0);
//        n6.next = n5;
//        n5.next = n4;
//        n4.next = n3;
//        n3.next = n2;
//        n2.next = n1;
//        n1.next = n0;
//
//        printList(n6);
//        ListNode newHead = reverseList(n6);
//        printList(newHead);


        ListNode n2 = new ListNode(4);
        ListNode n1 = new ListNode(2);
        ListNode n0 = new ListNode(0);


        n0.next = n1;
        n1.next = n2;


        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(3);
        ListNode n3 = new ListNode(1);


        n3.next = n4;
        n4.next = n5;

        ListNode newM = mergeSortedList(n0, n3);
        printList(newM);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        if (head == null || head.next == null)
            return head;
        else {
            newHead = head;
            head = head.next;
            newHead.next = null;
        }
        while (head != null) {
            ListNode t = head.next;
            head.next = newHead;
            newHead = head;
            head = t;
        }
        return newHead;

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

    public static ListNode mergeSortedList(ListNode LN1, ListNode LN2) {
        if (LN1 == null) {
            return LN2;
        }
        if (LN2 == null) {
            return LN1;
        }
        ListNode newMergedList = new ListNode(-1);
        ListNode ret = newMergedList;
        while (LN1 != null && LN2 != null) {
            if (LN1.val > LN2.val) {
                newMergedList.next = LN2;
                LN2 = LN2.next;
                newMergedList = newMergedList.next;
            } else {
                newMergedList.next = LN1;
                LN1 = LN1.next;
                newMergedList = newMergedList.next;

            }
        }
        if (LN1 == null) {
            newMergedList.next = LN2;
        }
        if (LN2 == null) {
            newMergedList.next = LN1;
        }
        return ret.next;

    }

}
