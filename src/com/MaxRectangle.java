package com;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by chengcheng on 1/12/17.
 */
public class MaxRectangle {
    public static void main(String[] args) {
        char[] c1 = "10100".toCharArray();
        char[] c2 = "10111".toCharArray();
        char[] c3 = "11111".toCharArray();
        char[] c4 = "10010".toCharArray();

        char[][] chars = {c1, c2, c3, c4};

        int max = maxRectangle(chars);
        System.out.println(max);
    }

    private static int maxRectangle(char[][] chars) {
        if (chars == null || chars.length == 0) return 0;
        int[] vertical = new int[chars[0].length];
        int max = 0;

        for (int i = 0 ; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] == '1') {
                    vertical[j] += 1;
                } else {
                    vertical[j] = 0;
                }
            }
            System.out.println(Arrays.toString(vertical));
            Stack<Integer> stack = new Stack<>();

            for (int k = 0; k <= vertical.length; k++) {
                int h = (k == vertical.length) ? 0 : vertical[k];
                if (stack.isEmpty() || h >= vertical[stack.peek()]) {
                    stack.push(k);
                } else {
                    h = vertical[stack.pop()];
                    int bottom = stack.isEmpty() ? k : k - stack.peek() - 1;
                    max = Math.max(max, h * bottom);
                }
            }
        }

        return max;

    }
}
