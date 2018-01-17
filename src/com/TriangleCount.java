package com;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chengcheng on 1/21/17.
 */
public class TriangleCount {
    public static void main(String[] args) {
        int[] S = {4,4,4,4};
        int triangle = triangleCount(S);
        System.out.println(triangle);

    }

    private static int triangleCount(int[] S) {
        if (S == null || S.length <=2 ) return 0;
        int count = 0;
        int k = S.length - 1;

        while (k > 1) {
            int target = S[k];
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (S[i] + S[j] > target) {
                    count += j - i; //since S[i] work, then S[i' > i && i' < j] work
                    j--;
                } else {
                    i++;
                }
            }
            k--;
        }
        return count;
    }


}

