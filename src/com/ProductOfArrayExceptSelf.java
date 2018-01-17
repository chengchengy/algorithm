package com;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int[] res = product(nums);
        System.out.println(Arrays.toString(res));
    }

    private static int[] product(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = left[i] * right;
            right = right * nums[i];
        }
        return res;
    }


}
