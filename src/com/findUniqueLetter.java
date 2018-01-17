package com;

import java.util.HashMap;

/**
 * Created by chengcheng on 8/31/16.
 */
public class findUniqueLetter {
    public static void main(String[] args) {
        String s = "dddccdbba";
//        int index = findUnique(s);
        int index = findUnique2(s);
        System.out.println("First unique: " + index);
    }

    private static int findUnique2(String s) {
        if (s == null || s == "") return -1;
        char[] array = new char[26];
        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i] - 97;
            array[index]++;
        }
        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i] - 97;
            if (array[index] == 1) return i;
        }
        return -1;
    }

//    private static int findUnique(String s) {
//        if (s == null || s == "") return -1;
//        HashMap<Character, Integer> map = new HashMap<>();
//        HashMap<Character, Integer> indexMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                indexMap.remove(s.charAt(i));
//            } else {
//                indexMap.put(s.charAt(i),i);
//                map.put(s.charAt(i), 1);
//            }
//        }
//        if (indexMap.size() == 0) {
//            return -1;
//        }
//
//        int index = Integer.MAX_VALUE;
//        for (Character c : indexMap.keySet()) {
//            if (index > indexMap.get(c)) {
//                index = indexMap.get(c);
//            }
//        }
//
//        return index;
//    }


}
