package DynamicProgramming._0091_Decode_Ways;

public class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int n = s.length();
        int dp0 = 0, dp1 = 1, dp = 0;
        for (int i = 0; i < n; i++) {
            dp = 0;
            if (s.charAt(i) != '0') {
                dp += dp1;
            }
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))) {
                dp += dp0;
            }
            if (i > 0 && s.charAt(i) == '0' && s.charAt(i - 1) > '2') {
                return 0;
            }
            dp0 = dp1;
            dp1 = dp;
        }
        return dp;
    }
}
