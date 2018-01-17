package com;

import java.util.List;

/**
 * Created by chengcheng on 9/1/17.
 */
public class ArrayNesting {
    private int maxDepth;

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0 && nums[k] < nums.length; size++) {
                int ak = nums[k];
                nums[k] = -1;
                k = ak;
            }
            max = Math.max(max, size);
        }
        return max;
    }


}

