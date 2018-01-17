package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by chengcheng on 1/16/17.
 */
public class DifferentWaysToAddParentheses241 {
    static HashSet<Character> operators = new HashSet<>();

    public static void main(String[] args) {

        String input = "2*3-4*5";
        List<Integer> list = diff(input);
        System.out.println(list);

    }

    public static List<Integer> diff(String input) {

    List<Integer> list = new ArrayList<>();
    if (input == null || input.length() == 0) return list;

    operators.add('+');
    operators.add('-');
    operators.add('*');

    Stack<Character> stack = new Stack<>();
    for (char c : input.toCharArray()) {
        stack.push(c);
    }

    while (!stack.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        while (!operators.contains(stack.peek())) {
            sb.append(stack.pop());
        }
        int cur = Integer.valueOf(sb.reverse().toString());
        char op = stack.pop();
        int tmp = 0;
        switch(op) {
            case '+': tmp = helper(stack) + cur;
                break;
            case '-': tmp = helper(stack) - cur;
                break;
            case '*': tmp = helper(stack) * cur;
                break;
        }
        list.add(tmp);
    }

    return list;
}

    private static int helper(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && !operators.contains(stack.peek())) {
            sb.append(stack.pop());
        }

        int cur = Integer.valueOf(sb.reverse().toString());
        if (stack.isEmpty()) {
            return cur;
        }


        char op = stack.pop();
        int tmp = 0;
        switch(op) {
            case '+': tmp = helper(stack) + cur;
                break;
            case '-': tmp = helper(stack) - cur;
                break;
            case '*': tmp = helper(stack) * cur;
                break;
        }
        return tmp;
    }
}
