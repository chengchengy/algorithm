package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by chengcheng on 12/2/16.
 */
public class CanIWin {
    public static void main(String[] args) {
        int maxChoosableInteger = 10;
        int desiredTotal = 11;
        boolean canIWin = canWin(maxChoosableInteger, desiredTotal);
        System.out.println(canIWin);
    }

    private static Map<Integer, Boolean> map;
    private static boolean[] visited;
    private static boolean canWin(int max, int total) {
        int sum = max * (1 + max) / 2;
        if (sum < total) return false;
        if (total <= 0) return true;
        //since sum < total, first peaple can chose a one > 0
        map = new HashMap<>();
        visited = new boolean[max + 1]; //1-n, waste 0
        return helper(total);
    }

    private static boolean helper(int total) {
        if (total <= 0) return false;
        int key = getKey(visited);
        if (!map.containsKey(key)) {
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (!helper(total - i)) {
                        map.put(key, true);
                        visited[i] = false;
                        return true;
                    }
                    visited[i] = false; //backtracking
                }
                map.put(key, false);
            }
        }
        return map.get(key);
    }

    private static int getKey(boolean[] visited) {
        int cur = 0;
        for (boolean v : visited) {
            cur <<= 1;
            if (v) {
                cur|= 1;
            } else {
                cur |= 0;
            }
        }
        return cur;
    }


}
