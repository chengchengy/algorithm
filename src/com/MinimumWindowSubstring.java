package com;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chengcheng on 3/29/17.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "bdab";
        String res = minWindow(s, "ab");
        System.out.println(res);
    }

    private static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return "";
            map.put(c, map.get(c) + 1);
        }

        int len = t.length();
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) > 0) {
                cnt++;
            }
            map.put(c, map.get(c) - 1);
            while (cnt == len) {
                System.out.println(minLen);
                if (minLen > i - start + 1) {
                    minLen = i - start + 1;
                    minStart = start;
                }
                char first = s.charAt(start++);
                map.put(first, map.get(first) + 1);
                if (map.get(first) > 0) cnt--;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }


}
