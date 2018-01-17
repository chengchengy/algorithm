package com;

import java.util.List;

/**
 * Created by chengcheng on 10/26/16.
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        int[] num = {1,4,3,2,5,2};
        head = ListNode.create(num);
        ListNode res = partition(head, 3);
        ListNode.printListNode(res);
    }

    private static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dmy = new ListNode(0);
        ListNode dmy2 = new ListNode(0);
        ListNode res = dmy;
        ListNode more = dmy2;
        while (head != null ) {
            if (head.val <= res.next.val) {
                dmy.next = head;
                dmy = dmy.next;
            } else {
                dmy2.next = head;
                dmy2 = dmy2.next;
            }
            head = head.next;
        }
        dmy2.next = null;
        dmy.next = more.next;
        return res.next;
    }
}
