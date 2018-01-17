package com;

/**
 * Created by chengcheng on 11/2/16.
 */
public class AddTwoNumII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        int[] n1 = {7,2,4,3};
        int[] n2 = {5,6,4};
        l1 = ListNode.create(n1);
        l2 = ListNode.create(n2);
        ListNode l = addII(l1, l2);
        ListNode.printListNode(l);
    }


    private static ListNode addII(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        l1 = ListNode.reverse(l1);
        l2 = ListNode.reverse(l2);

        ListNode l3 = add(l1, l2);
        ListNode res = l3;

        while (res.next != null) {
            res = res.next;
        }
        if (res.val == 0) {
            res = null;
        }

        l3 = ListNode.reverse(l3);
        return l3;
    }

    private static ListNode add(ListNode l1, ListNode l2) {

        ListNode dmy = new ListNode(0);
        ListNode res = dmy;

        int cnt = 0;
        while (!(l1 == null && l2 == null && cnt == 0)) {
            int current = 0;
            if (l1 == null && l2 == null) {
                dmy.next = new ListNode(cnt);
                cnt = 0;
            } else {
                current = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + cnt;

                if (current > 9) {
                    current = current - 10;
                    cnt = 1;
                } else {
                    cnt = 0;
                }
                dmy.next = new ListNode(current);
                dmy = dmy.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
        }


        return res.next;
    }
}
