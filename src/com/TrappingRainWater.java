package com;

import java.util.Stack;

/**
 * Created by chengcheng on 1/21/17.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] S = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int water = trappingWater(S);
//        System.out.println(water);
        int water2 = trappingWater2pointers(S);

        System.out.println(water2);

    }

    private static int trappingWater2pointers(int[] heights) {
        if (heights == null || heights.length < 3) return 0;
        int left = 0, right = heights.length - 1;
        int res = 0;
        if(left >= right)
            return res;
        int leftheight = heights[left];
        int rightheight = heights[right];
        while(left < right) {
            if(leftheight < rightheight) {
                left ++;
                if(leftheight > heights[left]) {
                    res += (leftheight - heights[left]);
                } else {
                    leftheight = heights[left];
                }
            } else {
                right --;
                if(rightheight > heights[right]) {
                    res += (rightheight - heights[right]);
                } else {
                    rightheight = heights[right];
                }
            }
        }
        return res;

//        if (heights == null || heights.length < 3) return 0;
//
//        int i = 0, j = heights.length - 1;
//        int leftMax = 0;
//        int rightMax = 0;
//
//        int water = 0;
//
//        while (i <= j) {
//            leftMax = Math.max(leftMax, heights[i]); // max within [0..i]
//            rightMax = Math.max(rightMax, heights[j]); // max within [j..n-1]
//
//            if (leftMax < rightMax) {
//                water += leftMax - heights[i++];
//            }
//            else {
//                water += rightMax - heights[j--];
//            }
//        }
//        return water;
    }

    private static int trappingWater(int[] heights) {
        if (heights == null || heights.length < 3) return 0;
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = heights.length - 1;
        while (heights[left + 1] >= heights[left]) left++;
        while (heights[right - 1] >= heights[right]) right--;

        int water = 0;

        for (int i = left; i <= right; i++) {
            if (stack.isEmpty() || heights[stack.peek()] > heights[i]) {
                stack.push(i);
            } else {
                int lowest = heights[stack.pop()];
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                int h = Math.min(heights[i],  heights[stack.peek()]) - lowest;
                water += h * (i - stack.peek() - 1);
                i--;
            }
        }

        return water;
    }


}

