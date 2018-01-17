package com;

import java.util.HashMap;

/**
 * Created by chengcheng on 1/7/17.
 */
public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        String s = "bdab";
        String t = "ab";
        String minWin = minWinSubstring(s, t);
        System.out.println(minWin);
    }

    private static String minWinSubstring(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) return "";
        if (s.equals(t)) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String res = s + ".";
        int min = s.length() + 1;

        for (int i = 0; i <= s.length() - t.length(); i++) {
            HashMap<Character, Integer> copy = new HashMap<>(map);
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (copy.containsKey(c)) {
                    int n = copy.get(c) - 1;
                    if (n != 0) {
                        copy.put(c, n);
                    } else {
                        copy.remove(c);
                    }
                    if (copy.size() == 0) {
                        String str = s.substring(i, j + 1);
                        if (str.length() < min) {
                            min = str.length();
                            res = str;
                        }
                    }
                } else {
                    if (j == i) break;
                }
            }
        }
        return res.length() == s.length() + 1 ? "" : res;
    }
}
