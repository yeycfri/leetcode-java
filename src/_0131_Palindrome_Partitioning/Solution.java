package _0131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String[][] dp;

    public List<List<String>> partition(String s) {
        dp = new String[s.length()][s.length()];
        backtracking(s, 0);
        return ans;
    }

    private void backtracking(String s, int splitIdx) {
        if (splitIdx >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = splitIdx; i < s.length(); i++) {
            String str = isPalindrome(s, splitIdx, i);
            if (str == null) continue;
            path.add(str);
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private String isPalindrome(String s, int left, int right) {
        if (left > right) return null;
        if (dp[left][right] != null) return dp[left][right];
        int low = left, high = right;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return null;
            left++;
            right--;
        }
        return dp[low][high] = s.substring(low, high + 1);
    }
}
