package com;

import java.util.Arrays;

/**
 * Created by chengcheng on 3/5/17.
 */
public class Closet3Sum {
    public static void main(String[] arg) {
        int[] nums = {4,4,4,7};
        int target = 12;
        int close = threeSumClosest(nums, target);
        System.out.println(close);
    }

    private static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        int n = nums.length;
        for (int i = 0; i + 3 <= n; i++) {
            int l = i + 1;
            int r = n - 1;
            int sum = 0;

            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;

                if (sum > target) {
                    r--;
                } else {
                    l++;
                }

                if (min == Integer.MAX_VALUE) {
                    min = Math.abs(sum - target);
                    res = sum;
                } else {
                    if (Math.abs(sum - target) < min) {
                        min = Math.abs(sum - target);
                        res = sum;
                    }
                }
            }
        }
        return res;
    }
}
