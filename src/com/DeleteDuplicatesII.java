package com;

/**
 * Created by chengcheng on 10/26/16.
 */
public class DeleteDuplicatesII {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        int[] nums = {1,1};
        head = ListNode.create(nums);
        head = delete(head);
        ListNode.printListNode(head);
    }
    private static ListNode delete(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        ListNode res = dmy;
        boolean flag = false; //no duplicate

        while (head != null && head.next != null) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
                flag = true;
            }
            head = head.next;
            if (!flag) {
                dmy = dmy.next;
            } else {
                dmy.next = head;
            }
            flag = false;
        }

        return res.next;
    }
}
