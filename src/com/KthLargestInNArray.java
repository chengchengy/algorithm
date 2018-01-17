package com;

import java.util.*;

/**
 * Created by chengcheng on 1/21/17.
 */
public class KthLargestInNArray {
    public static void main(String[] args) {
        int[][] array = {{}, {}, {1}, {1,2,3,4}, {11,10,9,8,7}};
        int k = 5;
        int kLargest = findKthLargest(array, k);
        System.out.println(kLargest);
    }

    private static int findKthLargest(int[][] array, int k) {
        if (array == null || array.length == 0) return 0;
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.val - o1.val;
            }
        });

        int i = -1;
        for (int[] a : array) {
            i++; //!!! even if the array is empty
            if (a == null || a.length == 0) continue;
            Arrays.sort(a);
            Node head = new Node(a[a.length - 1], i, a.length - 1);
            queue.offer(head);
        }
        int res = 0;
        while (k > 0 && !queue.isEmpty()) {
            Node cur = queue.poll();
            k--;
            if (k == 0) return cur.val;

            //next
            if (cur.c - 1 < 0) continue;
            int[] a = array[cur.r];
            Node head = new Node(a[cur.c - 1], cur.r, cur.c - 1);
            queue.offer(head);
        }

        return res;
    }

}

class Node {
    int r;
    int c;
    int val;

    public Node(int val, int r, int c) {
        this.val = val;
        this.r = r;
        this.c = c;
    }
}
