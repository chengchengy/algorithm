package com;

/**
 * Created by chengcheng on 12/3/16.
 */
public class PlusOneLinkedList {
    private static int add = 1;
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        int[] nums = {9,9,9};
        head = ListNode.create(nums);
//        head = plusonelinkedlist(head);
        head = plusOne(head);
        ListNode.printListNode(head);

    }

    private static ListNode plusOne(ListNode head) {
        if (head == null)
            return new ListNode(1); //last+
        ListNode plused = plusOne(head.next);
        if (plused != head.next) //last
            head.val++;
        if (head.val <= 9)
            return head;
        head.val = 0;
        plused.next = head;
        return plused;
    }
//    private static ListNode plusonelinkedlist(ListNode head) {
//        if (head == null) {
//            return new ListNode(1);
//        }
//
//        ListNode dmy = new ListNode(0);
//        dmy.next = head;
//        dmy.next = helper(dmy.next);
//
//        if (add == 1) {
//            ListNode res = new ListNode(1);
//            res.next = dmy.next;
//            return res;
//        }
//
//        return dmy.next;
//
//    }
//
//    private static ListNode helper(ListNode node) {
//        if (node.next == null) { //it is the last node
//            int cur = node.val + 1;
//            node.val = cur % 10;
//            add = cur > 9 ? 1 : 0;
//            return node;
//        }
//        System.out.println(add);
//
//        node.next = helper(node.next);
//
//        int cur = node.val + add;
//
//        node.val = cur % 10;
//        add = cur > 9 ? 1 : 0;
//
//        return node;
//    }

}
