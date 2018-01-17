package com;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by chengcheng on 1/7/17.
 */
public class LongestSubstringKDistinctCharacters {
    public static void main(String[] args) {
        int i = 0;
        String s = "eceba";
        int k = 3;
        int longestK = lengthOfLongestSubstringKDistinct(s, k);
        int longestK2 = lengthOfLongestSubstringKDistinct2(s, k);

        System.out.println(longestK);
        System.out.println(longestK2);
//
    }

    private static int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        int j = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;

        for (int i = 0; i < s.length() && j < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (map.size() > k) {//>
//                len = Math.max(len, i - j + 1);
                int first = map.get(s.charAt(j)) - 1;
                if (first == 0) {
                    map.remove(s.charAt(j));
                } else {
                    map.put(s.charAt(j), first);
                }
                j++;
            }
            len = Math.max(len, i - j + 1);
        }

        return len;
    }

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
