package com;

import java.util.List;

/**
 * Created by chengcheng on 10/19/16.
 */
public class SwapNodes {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = new ListNode(0).create(num);

        ListNode swapNode = swap(head);

    }

    private static ListNode swap(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        head = dmy;
        while (head != null && head.next != null) {
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
            ListNode.printListNode(dmy.next);

        }


        return dmy.next;

    }
}
