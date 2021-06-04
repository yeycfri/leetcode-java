package _0242_Valid_Anagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--record[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
