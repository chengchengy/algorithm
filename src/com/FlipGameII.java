package com;

import java.util.*;

/**
 * Created by chengcheng on 12/2/16.
 */
public class FlipGameII {
    public static void main(String[] args) {


    }

    public static boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        HashSet<String> winSet = new HashSet<>();
        return helper(s, winSet);
    }

    private static boolean helper(String s, HashSet<String> winSet) {
        if (winSet.contains(s)) return true;
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(t, winSet)) {
                    winSet.add(s);
                    return true;
                }
            }
        }
        return false;
    }

}
