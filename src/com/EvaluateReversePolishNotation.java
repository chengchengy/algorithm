package com;

import java.util.Stack;

/**
 * Created by chengcheng on 8/31/16.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"0", "3", "+"};
        int polishNotation = evaluateReversePolishNotation(tokens);
        System.out.println(polishNotation);
    }

    private static int evaluateReversePolishNotation(String[] tokens) {
        if(tokens == null || tokens.length == 0) {return 0;}
        Stack<String> stack = new Stack<>();

        for (String s : tokens) {
            if (s == "+" || s == "-" || s == "*" || s == "/") {
                int second = Integer.valueOf(stack.pop());
                int first = Integer.valueOf(stack.pop());
                int res = 0;

                if (s == "+") {
                    res = first + second;
                } else if (s == "-") {
                    res = first - second;
                } else if (s == "*") {
                    res = first * second;
                } else {
                    res = first / second;
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }


}
