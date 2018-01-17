package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by chengcheng on 1/5/17.
 */
public class RearrangeStringkDistance {
    public static void main(String[] args) {
        String str = "aaabbbbccccddddd";
        int k = 2;
        String res = rearrange(str, k);
    }
    private static String rearrange(String str, int k) {
        if (str == null || str.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<Character>((c1, c2) -> (map.get(c2) - map.get(c1)));

        for (char c : map.keySet()) {
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        int len = str.length();

        while (!pq.isEmpty()) {
            int cnt = Math.min(k, len);
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                if (pq.isEmpty()) return "";
                char c = pq.poll();
                sb.append(c);
                map.put(c,  map.get(c) - 1);
                if (map.get(c) > 0) {
                    list.add(c);
                }
                len--;
            }

            if (list.size() > 0) {
                for (char c : list) {
                    pq.offer(c);
                }
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }



}


