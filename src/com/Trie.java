package com;

/**
 * Created by chengcheng on 2/7/17.
 */
public class Trie {
    private static TrieNode root;

    public static void main(String[] args) {
        Trie begin = new Trie();
        insert("aa");
        boolean flag1 = search("aa");
        boolean flag2 = search("a");

//        boolean flag2 = startsWith("a");
//        boolean flag3 = startsWith("linterror");
        insert("a");
        boolean flag4 = search("a");
//        boolean flag5 = startsWith("linterror");
    }

    public Trie() {
        root = new TrieNode(); //start node is empty
    }

    // Inserts a word into the trie.
    public static void insert(String word) {
        TrieNode cur = root;
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            char c = wordArr[i];
            if (cur.chList[c - 'a'] == null) {
                TrieNode next = new TrieNode();
                next.ch = c;
                cur.chList[c - 'a'] = next;
            }
            cur = cur.chList[c - 'a'];
            if (i == wordArr.length - 1) {//last character
                cur.finish = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public static boolean search(String word) {
        TrieNode cur = root;
        char[] wordArray = word.toCharArray();
        int i = 0;
        for (; i < wordArray.length; i++) {
            char c = wordArray[i];
            if (cur.chList[c - 'a'] == null) return false;
            cur = cur.chList[c - 'a'];
            if (i == wordArray.length - 1) {
                if (cur.finish) return true;
            }
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public static boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] wordArray = prefix.toCharArray();
        int i = 0;
        for (; i < wordArray.length; i++) {
            int c = wordArray[i];
            if (cur.chList[c - 'a'] == null) return false;
            cur = cur.chList[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    Character ch;
    TrieNode[] chList;
    boolean finish;

    public TrieNode() {
        ch = '.';
        finish = false;//finish a word
        chList = new TrieNode[26];
    }


}