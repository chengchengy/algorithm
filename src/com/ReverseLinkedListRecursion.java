package com;

import java.util.HashMap;
import java.util.Map;

public class ReverseLinkedListRecursion {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode rev = reverse(head);
        while (rev != null) {
            System.out.print(rev.val + ", ");
            rev = rev.next;
        }

    }

    private static ListNode newHead;

    private static ListNode reverse(ListNode head) {
        if (head == null) return head;
        helper(head);
        return newHead;
    }

    private static ListNode helper(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return head;
        }
        ListNode pre = helper(head.next);
        pre.next = head;
        head.next = null; //!!!否则无限循环
        return head;
    }
}
