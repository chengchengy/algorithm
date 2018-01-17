package com;

/**
 * Created by chengcheng on 2/21/17.
 */
public class CopyBooks {
    public static void main(String[] args) {
        int[] pages = {1,1,1,1,1,1,1,1,1};
        int k = 4;
        int time = copyBooks(pages, k);
        System.out.println(time);
    }

    private static int copyBooks(int[] pages, int k) {
        int n = pages.length;
        int[][] dp = new int[k + 1][n + 1];
        int[] sum = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + pages[i];
            dp[1][i + 1] = sum[i + 1];
            max = Math.max(max, pages[i]);
        }
        if (k >= n) return max;

        for (int i = 2; i <= k; i++) {
            for (int j = n; j > 1; j--) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], sum[j] - sum[j - 1]);
                int min = dp[i][j];
                for (int t = j - 2; t >= i - 1; t--) {
                    int tmp = Math.max(dp[i - 1][t], sum[j] - sum[t]);
                    if (tmp < min) {
                        dp[i][j] = tmp;
                        min = tmp;
                    }
                }
            }
        }
        return dp[k][n];
    }
}
