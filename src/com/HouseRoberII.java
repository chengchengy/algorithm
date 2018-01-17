package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by chengcheng on 12/20/16.
 */
public class HouseRoberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int max = houseRober(nums);
        System.out.println(max);
    }

    private static int houseRober(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));

    }

    private static int helper(int[] nums, int lo, int hi) {
        if (lo > hi) return 0;
        if (lo == hi) return nums[lo];
//        if (lo == hi - 1) return Math.max(nums[lo], nums[hi]);
        int rob = nums[lo];
        int notRob = 0;
        for (int i = lo + 1; i <= hi; i++) {
            int preRob = rob;
            rob = notRob + nums[i];
            notRob = Math.max(notRob, preRob); //notRob for next time
        }
        return Math.max(rob, notRob);
    }


}
