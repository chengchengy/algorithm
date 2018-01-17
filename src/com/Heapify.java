package com;

import java.util.Arrays;

/**
 * Created by chengcheng on 2/12/17.
 */
public class Heapify {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,0};
        heaplify(nums);
    }

    private static void heaplify(int[] nums) {
//        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            shiftDown(i, nums);
        }

    }

    private static void shiftDown(int i, int[] nums) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int size = nums.length;

        while (left < size || right < size) {
            int leftVal = (left < size) ? nums[left] : Integer.MAX_VALUE;
            int rightVal = (right < size) ? nums[right] : Integer.MAX_VALUE;
            int next = (leftVal <= rightVal) ? left : right; //next for what
            if (nums[i] < nums[next]) break;
            swap(nums, i, next);
            i = next;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}
