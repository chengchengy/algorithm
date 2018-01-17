package com;

/**
 * Created by chengcheng on 9/15/16.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 1001001;
//        int t1 = n % 10;
//        int t2 = n / 10;
        boolean palindrome = isPalindrome(n);
        System.out.println("is palindrome? " + palindrome);
    }

    private static boolean isPalindrome(int n) {
        if (n < 10 && n >= 0) return true;
        if (n < 0 || n % 10 == 0) return false;
        int half = 0;
        while (n > half) {
            half = half * 10 + n % 10;
            n /= 10;
        }
        if (n == half || n == half / 10) return true;
        return false;
    }
}
