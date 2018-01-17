package com;

import java.util.*;

/**
 * Created by chengcheng on 1/21/17.
 */
public class Test {
    public static void main(String[] args) {
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        q.add(1);
//        q.add(1);
//        System.out.println(q.offer(1));
//        System.out.println(q.offer(2));
//
//        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
//            public int compare(Pair p1, Pair p2) {
//                return p1.val - p2.val;
//            }
//        });
        int[] num = {2,16,5,3,1,8};
//        Arrays.sort(num, Collections.reverseOrder());
        String[] str = {"hello", "a", "b", "world", "cc"};
        Arrays.sort(str, Collections.reverseOrder());
//        System.out.println(Arrays.toString(str));

        List<Integer> list = new ArrayList<>();
        for (int i : num) {
            list.add(i);
        }

        Collections.sort(list, (i1, i2) -> (i1 - i2));
        System.out.println(list);
    }
    public class Pair {
        int val;
        int r;
        int c;
        Pair(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }
}
