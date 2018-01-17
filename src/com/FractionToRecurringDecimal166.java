package com;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Created by chengcheng on 1/2/17.
 */
public class FractionToRecurringDecimal166 {
    public static void main(String[] args) {
        int numerator = 4;
        int denominator = 333;
//        System.out.println(numerator % denominator);
        String decimal = fractionToDecimal(numerator, denominator);
        System.out.println(decimal);
    }
    private static String fractionToDecimal(int numerator, int denominator) {
        //int to long
        String negative = (numerator * denominator < 0) ?  "-" : "";
        String res = negative;
        long n = Math.abs(Long.valueOf(numerator));
        long d = Math.abs(Long.valueOf(denominator));

        long one = n / d;
        long remain = n % d * 10;
        res += String.valueOf(one);

        if (remain == 0) {
            return res;
        }
        res += ".";

        HashMap<Long, Integer> map = new HashMap<>();

        while (remain != 0) {
            if (map.containsKey(remain)) {
                String repreat = res.substring(map.get(remain));
                String pre = res.substring(0, map.get(remain));
                res = pre + "(" + repreat + ")";
                break;
            }
            map.put(remain, res.length());
            one = remain / d;
            res += String.valueOf(one);
            remain = remain % d * 10;

        }
        return res;
    }

}
