package com;

import java.util.Arrays;

/**
 * Created by chengcheng on 12/2/16.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {8, 0, 5, 6, 9, 7, 6, 4};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] n, int start, int end) {
        if (n == null || n.length == 0) return;
        if (start >= end) return;

        int i = start;
        int j = end;
        int mid = start + (end - start) / 2;
        int pivot = n[mid];
        while (i <= j) { //i <= j, when i == j, still going down to make i != j
            while (n[i] < pivot && i <= end) i++;
            while (n[j] > pivot && j >= start) j--;
            if (i <= j) {
                swap(n, i, j);
                i++;
                j--;
            }
        }
        if (start < j) quickSort(n, start, j);
        if (i < end) quickSort(n, i, end);

    }

    private static void swap(int[] n, int i, int j) {
        int tmp = n[j];
        n[j] = n[i];
        n[i] = tmp;
    }
}
