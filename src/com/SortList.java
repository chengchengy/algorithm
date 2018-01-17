package com;

import java.util.ArrayList;

/**
 * Created by chengcheng on 11/1/16.
 */
public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        int[] num = {2, 1, 4, 3, 1};
        head = ListNode.create(num);
        head = sort(head);
        ListNode.printListNode(head);
    }

    private static ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;
        ArrayList<Integer> list = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        sortHelper(list, 0, list.size() - 1);

        ListNode dmy = new ListNode(0);
        ListNode res = dmy;

        for (int x : list) {
            dmy.next = new ListNode(x);
            dmy = dmy.next;
        }

        return res.next;
    }

    private static void sortHelper(ArrayList<Integer> list, int start, int end) {
        if (list == null || list.size() == 0) return;
        if (start >= end) return;

        int i = start;
        int j = end;
        int pivot = list.get(start + (end - start) / 2);

        while (i <= j) {
            while (list.get(i) < pivot && i < end) i++;
            while (list.get(j) > pivot && j > start) j--;

            if (i <= j) {
                int tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
                i++;
                j--;
            }
        }

        System.out.println(list.toString());

//        if (i > start) sortHelper(list, start, i);
//        if (j < end) sortHelper(list, j, end);

        if (start < j) sortHelper(list, start, j);
        if (i < end) sortHelper(list, i, end);

    }


}
