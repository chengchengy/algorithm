package com;

/**
 * Created by chengcheng on 2/21/17.
 */
public class CopyBooksII {
    public static void main(String[] args) {
        int[] times = {3,2,4};
        int k = 4;
        int time = copyBooksII(times, k);
        System.out.println(time);
    }

    private static int copyBooksII(int[] times, int n) {
        int k = times.length;

        int[][] dp = new int[k][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * times[0];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l <= j; l++) { //当前人读了多少本书
                    dp[i][j] = Math.min(dp[i][j], Math.max(l * times[i], dp[i - 1][j - l]));
                    if (dp[i - 1][j - l] <= times[i] * l) {
                        break;//避免无效的计算, 当dp[i - 1][j - l] <= times[i] * l时说明不会再有大小的问题,都是累加当前times了

                    }

                }
            }
        }
        return dp[k - 1][n];
    }


}
