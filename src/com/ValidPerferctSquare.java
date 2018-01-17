package com;

/**
 * Created by chengcheng on 9/1/17.
 */
public class ValidPerferctSquare {
    private int maxDepth;

    public static void main(String[] args) {
        int n = 5;
        System.out.println(isPerfectSquare(n));
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0 || num == 1) return true;
        long i = 1;
        long j = num / 2;
        long n = num;
        while (i <= j) {
            long mid = i + (j - i) / 2;

            if (mid * mid > n) {
                j = mid - 1;
            } else if (mid * mid < n) {
                i = mid + 1;
            } else {
                return true; //must be here, cannot be at first
            }
        }
        return false;
    }


}

