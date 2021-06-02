package _0076_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int[] need = new int[128];
        for (int i = 0; i < n; i++) {
            need[t.charAt(i)]++;
        }

        int left = 0, right = 0, count = n;
        int minLen = Integer.MAX_VALUE, minLeft = 0;
        while (right < m) {
            if (need[s.charAt(right++)]-- >= 1) count--;
            while (count == 0) {
                if ((right - left) < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                if (need[s.charAt(left++)]++ == 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
