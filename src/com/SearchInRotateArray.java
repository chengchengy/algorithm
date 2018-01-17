package com;

import java.util.Arrays;

/**
 * Created by chengcheng on 1/21/17.
 */
public class SearchInRotateArray {
    public static void main(String[] args) {
        int[] nums = {3,1};
        boolean exist = search(nums, 3);
        System.out.println(exist);
    }

    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int i = 0;
        int j = nums.length -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[i]) { //i - mid
                if (nums[mid] > target && nums[i] <= target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (nums[mid] < nums[i]) {
                if (nums[mid] < target && nums[j] >= target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                i++;
            }
        }
        return false;
    }

}

