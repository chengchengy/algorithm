package com;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by chengcheng on 10/3/16.
 */
public class mergeSort {
    public static void main(String[] args) {
        int[] nums1 = {5,3,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,4};
        int n = 3;
        merge(nums1, m, nums2, n);

    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int[] tmp = new int[m + n];
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i > 0 && j > 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }


}
