package com;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chengcheng on 1/21/17.
 */
public class KthSmallestInMatrix {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}};
        int k = 18;
        int kSmall = findKthSmall(array, k);
        System.out.println(kSmall);
    }

    private static int findKthSmall(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return -1;
        if (k == 1) return matrix[0][0];
        int r = matrix.length;
        int c = matrix[0].length;
        if (k == r * c) return matrix[r - 1][c - 1];

        if (k > r * c) return -1;
        PriorityQueue<Node> queue = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });

        int[][] mark = new int[r][c];

        queue.offer(new Node(matrix[0][0], 0,0));
        mark[0][0] = 1;

        int[] a = {0, 1};
        int[] b = {1, 0};



        while (k > 0 && !queue.isEmpty()) {
            Node cur = queue.poll();
            k--;
            if (k == 0) return cur.val;

            for (int i = 0; i < 2; i++) {
                int x = cur.row + a[i];
                int y = cur.col + b[i];
                if (x >= r || y >= c || mark[x][y] != 0) continue;
                queue.offer(new Node(matrix[x][y], x, y));
                mark[x][y]++;
            }

        }

        return -1;
    }

    static class Node { //inner class
        int row;
        int col;
        int val;
        Node(int v, int r, int c) {
            this.val = v;
            this.row = r;
            this.col = c;
        }
    }


}

