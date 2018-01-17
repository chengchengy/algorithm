package com;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by chengcheng on 12/20/16.
 */
public class BullsAndCows299 {
    public static void main(String[] args) {
        String secret = "1122";
        String guess = "2211";
        String result = getHint(secret, guess);
        System.out.println(result);
    }

    private static String getHint(String secret, String guess) {
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                map.put(c, set);
            }
        }

        int bull = 0;
        int cow = 0;

        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);

            if (map.containsKey(c)) {
                if (map.get(c).contains(i)) {
                    bull++;
                } else {
                    cow++;
                }
            }
        }

        return bull + "A" + cow + "B";
    }
}
