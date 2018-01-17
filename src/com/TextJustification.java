package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengcheng on 9/1/17.
 */
public class TextJustification {

    public static void main(String[] args) {

        String[] words = {"Listen","to","many,","speak","to","a","few."};
        List<String> list = fullJustify(words, 6);
        System.out.println(list);

    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();

        int n = words.length;
        for (int i = 0; i < n; ) {
            int start = i;
            // int wordLen = 0;

            int len = -1;
            while (i < n && len + words[i].length() + 1 <= maxWidth) {
                // wordLen += words[i].length();
                len += words[i].length() + 1;
                i++;
            }

            int space = 1;
            int remain = 0;
            // if (len < maxWidth) { //"a",1
            if (i != start + 1 && i != n) { //not one word, not the last word
                space = (maxWidth - len) / (i - start - 1) + 1;
                remain = (maxWidth - len) % (i - start - 1);
            }
            // }

            StringBuilder sb = new StringBuilder();
            sb.append(words[start]);
            for (int j = start + 1; j < i; j++) {
                for (int s = 0; s < space; s++) {
                    sb.append(" ");
                }
                if (remain > 0) {
                    sb.append(" ");
                    remain--;
                }
                sb.append(words[j]);
            }
            int l = sb.length();

            if (i == start + 1 || i == n) { //one word, or last word
                for (int s = 0; s < maxWidth - l; s++) {
                    sb.append(" ");
                }
            }

            list.add(sb.toString());
        }
        return list;
    }
}

