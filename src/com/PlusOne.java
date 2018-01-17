package com;

import java.util.Arrays;

/**
 * Created by chengcheng on 12/3/16.
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] n = {1,0};
        int[] res = plusone(n, 1);
        System.out.println(Arrays.toString(res));
    }

    private static int[] plusone(int[] n, int add) {
        for (int i = n.length - 1; i >= 0; i--) {
            if (add == 0) break;
            int cur = n[i] + add;
            n[i] = cur % 10;
            add = cur - 9;
        }

        if (add == 1) {
            int[] res = new int[n.length + 1];
            res[0] = 1;
            int i = 1;
            for (int x : n) {
                res[i] = x;
                i++;
            }
            return res;
        }
        return n;
    }
}
