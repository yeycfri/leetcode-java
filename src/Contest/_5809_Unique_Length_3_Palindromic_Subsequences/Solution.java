package Contest._5809_Unique_Length_3_Palindromic_Subsequences;

public class Solution {

    public int countPalindromicSubsequence(String s) {
        int n = s.length(), ans = 0;

        // 枚举两侧字符
        for (char c = 'a'; c <= 'z'; c++) {
            int left = 0, right = n - 1;

            // 寻找该字符左边第一次出现的下标
            while (left < n && s.charAt(left) != c) {
                left++;
            }
            // 寻找该字符右边第一次出现的下标
            while (right >= 0 && s.charAt(right) != c) {
                right--;
            }

            // 统计中间不同的字符，26个字符可以用int 32位表示
            int bit = 0;
            for (int i = left + 1; i < right; i++) {
                bit |= (1 << (s.charAt(i) - 'a'));
            }
            ans += Integer.bitCount(bit);
        }
        return ans;
    }

    public int countPalindromicSubsequenceMid(String s) {
        int n = s.length();
        int[] pre = new int[n], suf = new int[n];
        for (int i = 0; i < n; i++) {
            // 前缀 s[0..i-1] 包含的字符种类
            pre[i] = (i == 0 ? 0 : pre[i - 1]) | (1 << (s.charAt(i) - 'a'));
            // 后缀 s[i+1..n-1] 包含的字符种类
            suf[n - 1 - i] = (i == 0 ? 0 : suf[n - i]) | (1 << (s.charAt(n - 1 - i) - 'a'));
        }
        int[] ans = new int[26];
        for (int i = 1; i < n - 1; i++) {
            ans[s.charAt(i) - 'a'] |= pre[i - 1] & suf[i + 1];
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt += Integer.bitCount(ans[i]);
        }
        return cnt;
    }
}
