package com;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chengcheng on 2/12/17.
 */
public class TrappingWaterII {
    public static void main(String[] args) {
        int[][] walls = {{12,13,0,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        int water = trappingWater(walls);
        System.out.println(water);
    }

    private static int trappingWater(int[][] walls) {
        int water = 0;
        if (walls == null || walls.length < 3) return water;
        PriorityQueue<Node> minQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });

                return 0;


    }

    class Node {
        int i;
        int j;
        int val;
        Node (int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}
