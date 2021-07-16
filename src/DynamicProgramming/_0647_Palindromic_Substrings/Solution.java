package DynamicProgramming._0647_Palindromic_Substrings;

public class Solution {

    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int countSubstringsTwoPointers(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            ans += countFrom(s, i, i, n);
            ans += countFrom(s, i, i + 1, n);
        }
        return ans;
    }

    private int countFrom(String s, int l, int r, int n) {
        int ans = 0;
        while (l > -1 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc"));
    }
}
