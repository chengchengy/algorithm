package com;

import com.sun.corba.se.impl.protocol.INSServerRequestDispatcher;

/**
 * Created by chengcheng on 9/1/17.
 */
public class ShortestWordDistanceIII {
    public static void main(String[] args) {
        String[] words = {"practice", "makes"};
        String word1 = "makes";
        String word2 = "practice";
        int dis = shortestWordDistance(words, word1, word2);
        System.out.println(dis);
    }

    private static int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return 0;
        int index = -1;
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                    dis = Math.min(dis, i - index);
                }
                index = i;
            }
        }
        return dis;
    }
}
