package com;

import java.util.*;

/**
 * Created by chengcheng on 10/3/16.
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "bcabc";
        String res = removeDuplicate(s);
        System.out.println(res);
    }

    private static String removeDuplicate(String s) {
        if (s == null || s == "" || s.length() == 1) return s;

        Stack<Character> stack = new Stack<>();
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() - 'a' > c - 'a' && array[stack.peek() - 'a'] != 0) {
//                int peek = stack.peek() - 'a';
//                if (peek > c - 'a' && array[peek] != 0) {
                    stack.pop();
//                }
            }
            stack.push(c);
            array[c - 'a']--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
