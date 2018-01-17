package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AAAATEST {
    public static void main(String[] args) {
        int[] nums = {7,8,9,5,1,2,3};
        int n = nums.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = (2 * i + 1) % (n|1);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(index));
        int i = 0;
        int lo = 0;
        int hi = n - 1;
        int mid = nums[n/2];

        /**
         * 我们可以按照这样一个顺序将数组索引拉开成这样: 1, 3, 5, 0, 2, 4,
         * 也就是我们可以按照这样一个顺序来遍历数组,
         * 同时维护一个低位指针lo用来代表奇数位置已经放到哪里,
         * 和一个高位指针hi来表示偶数位置已经放到哪里,
         * 这样在我们遍历数组的每一个元素的时候就可以按照这样的方式将元素分别放高位还是低位.
         * 而要将数组按照这样索引的方式遍历我们只需要一个映射即可, 即(2*i+1)%(len|1).
         */
        while (i <= hi) {
            if (nums[index[i]] > mid) {
                int first = index[i];
                int second = index[lo];
                swap(nums, index[i], index[lo]);
                i++;
                lo++;
            } else if (nums[index[i]] < mid) {
                int first = index[i];
                int second = index[lo];
                swap(nums, index[i], index[hi]);
                hi--;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
