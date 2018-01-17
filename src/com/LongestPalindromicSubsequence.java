package com;

import java.util.Arrays;

/**
 * Created by chengcheng on 11/2/16.
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "aaaba";
        int max = longestPalindrome(s);
        System.out.println(max);
    }

    private static int longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len]; // dp[i] = longest palindrome, found so far, starting from i
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {

            int curMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                int tmp = dp[j];
                if (str[j] == str[i]) {
                    dp[j] = curMax + 2;
                }
                curMax = Math.max(curMax, tmp);
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
