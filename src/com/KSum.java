package com;

/**
 * Created by chengcheng on 2/27/17.
 */
public class KSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 2;
        int target = 7;
        int cnt = kSum(nums, k, target);
        System.out.println(cnt);
    }

    private static int kSum(int[] A, int k, int target) {
        if (A == null || A.length == 0 || target <= 0 || k == 0) return 0;
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        f[0][0][0] = 1;

        for (int i = 0; i <= n; i++) {
            f[i][0][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {

                    f[i][j][t] = f[i - 1][j][t];
                    if (t - A[i - 1] >= 0) {
                        f[i][j][t] += f[i - 1][j - 1][t - A[i - 1]];
                    }

                }
            }
        }
        return f[n][k][target];
    }
}
