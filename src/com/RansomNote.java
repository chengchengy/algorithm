package com;

/**
 * Created by chengcheng on 8/31/16.
 */
public class RansomNote {
    public void main(String[] args) {
        String ransomNote = "bg";
        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";

        boolean flag = canConstruct(ransomNote, magazine);
        System.out.println(flag);
    }

    private boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null) return false;
        if (magazine.length() < ransomNote.length()) return false;

        char[] magazineArr = magazine.toCharArray();
        char[] charMagazine = new char[26];



        for (int i = 0; i < magazineArr.length; i++) {
            int index = magazineArr[i] - 97;
            charMagazine[index]++;
        }

        char[] ransomArr = ransomNote.toCharArray();
        char[] charRansom = new char[26];

        for (int i = 0; i < ransomArr.length; i++) {
            int index = ransomArr[i] - 97;
            charRansom[index]++;
        }

        for (int i = 0; i < ransomArr.length; i++) {
            int index = ransomArr[i] - 97;
            int num = charRansom[index];
            if (num > charMagazine[index]) return false;
        }

        return true;
    }
}

