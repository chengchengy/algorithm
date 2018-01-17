package com;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by chengcheng on 10/3/16.
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "10";
        String res = remove(num, 1);
        System.out.println("result: " + res);
    }

    private static String remove(String num, int k) {
//        if (k == num.length()) return "0";
//        if (k == 0) return num;
//        Stack<Character> stack = new Stack<>();
//        for (char c : num.toCharArray()) {
//            //must be while
//            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
//                stack.pop();
//                k--;
//            }
//            if (c == '0' && stack.isEmpty()) {
//                continue;
//            }
//            stack.push(c);
//        }
//        while (k > 0) {
//            if (!stack.isEmpty()) {
//                stack.pop();
//                k--;
//            } else {
//                return "0";
//            }
//        }
////        if (stack.isEmpty()) return "0"; //not necessary
//
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.insert(0, stack.pop());
//        }
//        System.out.println("res: " + sb.toString());
//        return sb.toString().equals("")? "0" : sb.toString();

        //second
        //pick, not remove, 在给定区间里选择
        if (k == 0) return num;
        if (k == num.length()) return "0";
        int left = -1;
        int remain = num.length() - k;
        StringBuilder sb = new StringBuilder();

        while (remain > 0) {
            int right = num.length() - remain;
            char min = '9' + 1; //should be char
            for (int i = left + 1; i <= right; i++) {
                if (num.charAt(i) < min) {
                    min = num.charAt(i);
                    left = i;
                }
            }
            if (sb.length() != 0 || min != '0') sb.append(min);
            remain--;
        }
        if (sb.length() == 0) return "0";
        return sb.toString();

    }


}
