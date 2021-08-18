package Greedy._0032_Longest_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0, maxLen = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                l++;
            else
                r++;
            if (l == r)
                maxLen = Math.max(maxLen, r << 1);
            if (l < r)
                l = r = 0;
        }
        l = r = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                l++;
            else
                r++;
            if (l == r)
                maxLen = Math.max(maxLen, r << 1);
            if (l > r)
                l = r = 0;
        }
        return maxLen;
    }
}
