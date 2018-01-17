package com;

import java.util.*;

/**
 * Created by chengcheng on 1/21/17.
 */
public class KthSmallestSumInTwoArray {
    public static void main(String[] args) {
        int[] A = {1, 7, 11};
        int[] B = {2,4,6};
        int k = 8;
        int kSmall = findKthSmallSum(A, B, k);
        System.out.println(kSmall);
    }

    private static int findKthSmallSum(int[] A, int[] B, int k) {
        if (k <= 0 || A == null || B == null || A.length == 0 || B.length == 0) return -1;

        PriorityQueue<Node> queue = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });

        int[] n = {0, 1};
        int[] m = {1, 0};
        int[][] mark = new int[A.length][B.length];

        queue.offer(new Node(A[0] + B[0], 0, 0));

        mark[0][0]++;

        while (k > 0) {
            Node cur = queue.poll();
            k--;
            if (k == 0) return cur.val;
            for (int i = 0; i < 2; i++) {
                int x = cur.a + n[i];
                int y = cur.b + m[i];
                if (x < A.length && y < B.length && mark[x][y] == 0) {

                        queue.offer(new Node(A[x] + B[y], x, y));
                    mark[x][y]++;

                }
            }

        }
        return -1;
    }
    static  class Node {
        int val;
        int a;
        int b;
        Node (int val, int a, int b) {
            this.val = val;
            this.a = a;
            this.b = b;
        }
    }

}

