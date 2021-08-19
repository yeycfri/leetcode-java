package StackAndQueue._0085_Maximal_Rectangle;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] heights = new int[m][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    heights[i][j + 1] = i == 0 ? 1 : heights[i - 1][j + 1] + 1;
            }
        }
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 2; j++) {
                while (!stack.isEmpty() && heights[i][j] < heights[i][stack.peek()]) {
                    int h = heights[i][stack.pop()];
                    ans = Math.max(ans, h * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
            stack.clear();
        }
        return ans;
    }
}
