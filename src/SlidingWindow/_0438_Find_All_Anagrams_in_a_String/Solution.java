package SlidingWindow._0438_Find_All_Anagrams_in_a_String;

import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m < n) return ans;

        int[] need = new int[26];
        for (char ch : p.toCharArray()) {
            need[ch - 'a']++;
        }

        int left = 0, right = 0;
        int[] have = new int[26];
        while (right < m) {
            have[s.charAt(right) - 'a']++;
            if ((right - left + 1) == n) {
                if (Arrays.equals(need, have)) {
                    ans.add(left);
                }
                have[s.charAt(left++) - 'a']--;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
}
