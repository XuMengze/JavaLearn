package com.alg.LinkedList;


import com.alg.model.ListNode;

class Solution2 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        Solution2 s2 = new Solution2();

        int k = 3;
        ListNode newAMove = a;
        ListNode res = new ListNode(-1), resStatic = res;
        int count = 0;
        ListNode tmpListNode = new ListNode(-1), tmpListNodeMove = tmpListNode;
        while (true) {
            if (newAMove == null) {
                tmpListNode = tmpListNode.next;
                res.next = s2.reversiList(tmpListNode);
                break;
            }
            if (count < k) {
                ListNode node = new ListNode(newAMove.val);
                tmpListNodeMove.next = node;
                tmpListNodeMove = tmpListNodeMove.next;
                newAMove = newAMove.next;
                count++;
            } else {
                count = 0;
                tmpListNode = tmpListNode.next;
                res.next = s2.reversiList(tmpListNode);
                res = s2.moveToEnd(res);
                tmpListNode = new ListNode(-1);
                tmpListNodeMove = tmpListNode;
            }
        }
        s2.printListNode(resStatic.next);
    }

    public ListNode moveToEnd(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public ListNode reversiList(ListNode head) {
        ListNode newHead = null;
        if (head == null || head.next == null) {
            return head;
        } else {
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

    public void printListNode(ListNode head) {
        ListNode p = null;
        if (head != null) {
            p = head;
        }
        while (p != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }
    }
}