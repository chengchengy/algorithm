package com;

/**
 * Created by chengcheng on 3/1/17.
 */
public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "aabbb";
        int n = longestRepeaing(str);
        System.out.println(n);
    }

    private static int longestRepeaing(String str) {
        if (str == null || str.length() <= 1) return 0;
        int n = str.length();

        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                int tmp = 0;
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) tmp = 1;
                f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + tmp);

            }
        }
        return f[n][n];
    }
}
