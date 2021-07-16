package DynamicProgramming._0005_Longest_Palindromic_Substring;

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0, idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) continue;
                dp[i][j] = (j - i < 2) || dp[i + 1][j - 1];
                if (dp[i][j] && (j - i + 1 > max)) {
                    max = j - i + 1;
                    idx = i;
                }
            }
        }
        return s.substring(idx, idx + max);
    }

    public String longestPalindromeExpand(String s) {
        int n = s.length();
        int max = 0, l = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expand(s, i, i, n);
            int len2 = expand(s, i, i + 1, n);
            int len = Math.max(len1, len2);
            if (len > max) {
                max = len;
                l = i - (max - 1) / 2;
            }
        }
        return s.substring(l, l + max);
    }

    private int expand(String s, int l, int r, int n) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
