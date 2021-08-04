package StackAndQueue._0084_Largest_Rectangle_in_Histogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        int[] hh = new int[n + 2];
        System.arraycopy(heights, 0, hh, 1, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n + 2; i++) {
            while (!stack.isEmpty() && hh[stack.peek()] > hh[i]) {
                int h = hh[stack.pop()];
                ans = Math.max(ans, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return ans;
    }
}
