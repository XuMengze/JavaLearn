package com.alg.LinkedList;

import com.alg.model.ListNode;

import java.util.List;

public class DeleteDuplicate {
    public static void main(String[] args) {
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(5);
        ListNode n3 = new ListNode(4);
        ListNode n2 = new ListNode(4);
        ListNode n1 = new ListNode(4);
        ListNode n0 = new ListNode(3);
        n6.next = n5;
        n5.next = n4;
        n4.next = n3;
        n3.next = n2;
        n2.next = n1;
        n1.next = n0;

        printList(n6);
        ListNode head = reverseList(n6);
        System.out.println();
        printList(head);
    }

    public static ListNode deleteDuplicate(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode formmer = head, latter = head.next;
        while (latter != null) {
            if (formmer.val == latter.val) {
                formmer.next = latter.next;
                latter = latter.next;
            } else {
                formmer = formmer.next;
                latter = latter.next;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

}
