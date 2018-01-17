package com;

import java.util.Arrays;

/**
 * Created by chengcheng on 1/21/17.
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        int[] nums = {0,0,1,2,2,2};

        System.out.println(badVersion(nums, 1));
    }

    private static int badVersion(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2 + 1;
            if (nums[mid] > target) {
                j = mid - 1;
            } else { // <=
                i = mid;
            }
        }
        return i;
    }


}

