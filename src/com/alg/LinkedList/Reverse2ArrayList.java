package com.alg.LinkedList;

import com.alg.model.ListNode;

import java.util.ArrayList;

public class Reverse2ArrayList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ArrayList list = printListFromTailToHead(a);

        System.out.println(list);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return new ArrayList<>();
        } else {
            while (listNode != null) {
                res.add(listNode.val);
                listNode = listNode.next;
            }
        }
        reverseArrayList(res);
        return res;
    }

    public static void reverseArrayList(ArrayList<Integer> needReverse) {
        int len = needReverse.size();
        int begin = 0, end = len - 1;
        while (begin < end) {
            needReverse.set(begin, needReverse.get(begin) ^ needReverse.get(end));
            needReverse.set(end, needReverse.get(begin) ^ needReverse.get(end));
            needReverse.set(begin, needReverse.get(begin) ^ needReverse.get(end));
            begin++;
            end--;
        }
    }
}
