package com;

import java.util.Arrays;

/**
 * Created by chengcheng on 10/26/16.
 */
public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {2, 3}, {1, 2}};
        int n = 4;
        System.out.println(validTree(n, edges));
    }

    private static boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            nums[x] = y;
        }
        return edges.length == n  -1;
    }

    private static int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }

}
