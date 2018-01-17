package com;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chengcheng on 3/5/17.
 */
public class ThreeSum {
    public static void main(String[] arg) {
        int[] nums = {1,0,-1,-1,-1,-1,0,1,1,1};
        ArrayList<ArrayList<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    private static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        int n = nums.length;
        int i = 0;

        Arrays.sort(nums);
        int pre = nums[i];
        while (i + 3 <= n) {
            if (nums[i] > 0) break;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);

                    int preLeft = nums[l];
                    while (l < n && preLeft == nums[l]) l++;

                    int preRight = nums[r];
                    while (r >= 0 && preRight == nums[r]) r--;

                } else if (sum > 0) {
                    int preRight = nums[r];
                    while (r >= 0 && preRight == nums[r]) r--;
                } else {
                    int preLeft = nums[l];
                    while (l < n && preLeft == nums[l]) l++;
                }
            }
            while (i  + 3 <= n && pre == nums[i]) {
                i++;
            }
            pre = nums[i];
        }
        return res;
    }


}
