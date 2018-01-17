package com;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

/**
 * Created by chengcheng on 8/31/16.
 */
public class DecodingString {
    public static void main(String[] args) {
        String s = "3[a2[cb]]";
        String reverse = decodeString(s);
        System.out.println("result: " + reverse);

    }

    private static String decodeString(String s) {
        if (s == null || s == "") return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit_begin = i;
                while (s.charAt(i) != '[') i++;
                int num = Integer.valueOf(s.substring(digit_begin, i));
                int count = 1;
                int str_begin = i+1;
                i ++;
                while (count != 0) {
                    if (s.charAt(i) == '[') count ++;
                    else if (s.charAt(i) == ']') count --;
                    i ++;
                }
                i--;
                String str = decodeString(s.substring(str_begin, i)); //ignore the last ]
                for (int j = 0; j < num; j ++) {
                    sb.append(str);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
