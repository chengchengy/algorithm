package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chengcheng on 1/21/17.
 */
public class RepeatedDNASequence {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = findRepeatedDNA(s);
        System.out.println(res);
    }

    public static List<String> findRepeatedDNA(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> res = new ArrayList<>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['C' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (int i = 0; i <= s.length() - 10; i++) {
            int cur = 0;
            for (int j = i; j < i + 10; j++) {
                cur = cur << 2;
                cur |= map[s.charAt(j) - 'A'];
            }
            if (!words.add(cur) && doubleWords.add(cur)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }


}

