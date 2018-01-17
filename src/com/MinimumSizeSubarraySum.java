package com;

/**
 * Created by chengcheng on 2/14/17.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int len = minimumSize(nums, 7);
        System.out.println(len);

    }

    private static int minimumSize(int[] nums, int s) {
        int len = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0) return -1;
        int j = 0;
        int sum = 0;
        for (int i = 0; i < nums.length && j < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                len = Math.min(len, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }

        return len == Integer.MAX_VALUE ? -1 : len;
    }
}
