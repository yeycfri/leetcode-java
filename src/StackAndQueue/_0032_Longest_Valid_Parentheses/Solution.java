package StackAndQueue._0032_Longest_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = s.length(), maxLen = 0;
        for (int i = 0, start = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    maxLen = Math.max(maxLen, i - (stack.isEmpty() ? start - 1 : stack.peek()));
                }
            }
        }
        return maxLen;
    }
}
