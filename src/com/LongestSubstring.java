package com;

import java.util.HashMap;

/**
 * Created by chengcheng on 1/1/17.
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abba";
        int len = longestSubstring(s);
        System.out.println(len);
    }

    private static int longestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int j = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
//                j = Math.max(j, map.get(c) + 1); //must be
                j = map.get(c) + 1;
            }
            len = Math.max(len, i - j + 1);
            map.put(c, i);
        }
        return len;
    }


}
