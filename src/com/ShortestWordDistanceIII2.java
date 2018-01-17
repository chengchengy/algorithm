package com;

/**
 * Created by chengcheng on 9/1/17.
 */
public class ShortestWordDistanceIII2 {
    public static void main(String[] args) {
        String[] words = "a,a,b,a,b,b".split(",");
        String word1 = "b";
        String word2 = "b";
        int dis = shortestWordDistance(words, word1, word2);
        System.out.println(dis);
    }

    private static int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return 0;
        boolean same = word1.equals(word2);
        int first = -1;
        int second = -1;
        int n = words.length;
        int min = Integer.MAX_VALUE;
        if (same) {
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) {
                    if (first != -1) {
                        min = Math.min(min, i - first);
                        first = i;
                    }
                }
            }

        } else {
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) {
                    first = i;
                }
                if (words[i].equals(word2)) {
                    second = i;
                }
                if (first != -1 && second != -1) {
                    min = Math.min(min, Math.abs(second - first));
                }
            }
        }
        return min;
    }
}
