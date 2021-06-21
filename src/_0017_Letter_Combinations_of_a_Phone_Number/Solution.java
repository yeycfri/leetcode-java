package _0017_Letter_Combinations_of_a_Phone_Number;

import java.util.*;

public class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    String[] nums = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) return ans;
        backtracking(digits, 0);
        return ans;
    }

    private void backtracking(String digits, int i) {
        if (str.length() == digits.length()) {
            ans.add(str.toString());
            return;
        }
        for (char c : nums[digits.charAt(i) - '0'].toCharArray()) {
            str.append(c);
            backtracking(digits, i + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
