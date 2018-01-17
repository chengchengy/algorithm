package com;

/**
 * Created by chengcheng on 2/24/17.
 */
public class Backpack {
    public static void main(String[] args) {
        int[] size = {2, 3, 5, 7};
        int capacity = 12;
        int full = backpack(size, capacity);
        System.out.println(full);
    }

    private static int backpack(int[] A, int m) {
        if (A == null || A.length == 0 || m == 0) return 0;
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        int max = 0;
        for (int i = 1; i <= n; i++) { //0 - m + 1
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= A[i-1] && dp[i-1][j - A[i-1]]) {
                    dp[i][j] = true;
                }

                if (dp[i][j]) {
                    max = Math.max(max, j);
                }
            }
        }

        return max;
    }
}
