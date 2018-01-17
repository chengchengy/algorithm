package com;

/**
 * Created by chengcheng on 2/24/17.
 */
public class BackpackVI {
    public static void main(String[] args) {
        int[] size = {1,2,4};
        int target = 4;
        int cnt = backpackVI(size, target);
        System.out.println(cnt);
    }

    private static int backpackVI(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) return 0;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i - n >= 0) {
                    f[i] += f[i - n];
                } else {
                    break;
                }
            }
        }
        return f[target];
    }


}
