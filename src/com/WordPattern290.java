package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by chengcheng on 12/20/16.
 */
public class WordPattern290 {
    public static void main(String[] args) {
        String pattern = "abbba";
        String str = "dog cat cat cat dd";
        boolean flag = wordPattern(pattern, str);
        System.out.println(flag);

    }

    private static boolean wordPattern(String pattern, String str) {

        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) return false;
        HashMap<Character, ArrayList<Integer>> pmap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (pmap.containsKey(c)) {
                pmap.get(c).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                pmap.put(c, list);
            }
        }

        HashSet<String> exist = new HashSet<>();

        for (char key : pmap.keySet()) {

            ArrayList<Integer> list = pmap.get(key);
            String first = arr[list.get(0)];
            if (exist.contains(first)) return false;
            exist.add(first);
            for (int i : list) {
                if (!arr[i].equals(first)) return false;
            }
        }

        return true;
    }
}
