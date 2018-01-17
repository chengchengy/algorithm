package com;

import java.util.List;

/**
 * Created by chengcheng on 10/26/16.
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        int[] num = {1,2,3,4,5,6};
        head = ListNode.create(num);
        ListNode reverse = reverseII(head, 2, 4);

        ListNode.printListNode(reverse);
    }

    private static ListNode reverseII(ListNode head, int m, int n) {
        if (m == n) return head;
        return head;
    }
}
