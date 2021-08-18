package DynamicProgramming._0032_Longest_Valid_Parentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), maxLen = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '(') continue;
            if (s.charAt(i - 1) == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i >= dp[i - 1] + 1 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + (i >= (dp[i - 1] + 2) ? dp[i - dp[i - 1] - 2] : 0);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
