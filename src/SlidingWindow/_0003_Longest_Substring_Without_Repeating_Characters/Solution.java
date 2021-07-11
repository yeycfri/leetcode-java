package SlidingWindow._0003_Longest_Substring_Without_Repeating_Characters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0, right = 0, n = s.length();
        int[] hash = new int[128];
        for (; right < n; right++) {
            hash[s.charAt(right)]++;
            while (hash[s.charAt(right)] > 1) {
                hash[s.charAt(left++)]--;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
