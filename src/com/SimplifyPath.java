package com;

import java.util.Stack;

/**
 * Created by chengcheng on 10/3/16.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        String res = simplify(path);
        System.out.println(res);

    }

    private static String simplify(String path) {
        if (path == null || path == "") return path;
        Stack<Character> stack = new Stack<>();
        char pre = '1';
        for (char c : path.toCharArray()) {
            if (pre == '/' && c == '/') {
                continue;
            }
            if (pre == '.' && c == '/') {
                stack.clear();
            }
            pre = c;
            stack.push(c);
        }
        if (stack.size() > 1 && stack.peek() == '/') {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
