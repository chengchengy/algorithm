package com;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by chengcheng on 1/21/17.
 */
public class SearchForRange {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int[] res = searchRange(nums, 2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] index = {-1, -1};
        index[0] = binarySearch1(nums, target);
        index[1] = binarySearch2(nums, target);
        return index;
    }

    private static int binarySearch1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (i == j && nums[i] == target) return i;
        return -1;
    }

    private static int binarySearch2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2 + 1;
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        if (i == j && nums[i] == target) return i;
        return -1;
    }


}

