package Backtracking._0694_Number_of_Distinct_Islands;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, i, j, path);
                    set.add(path.toString());
                }
            }
        }
        return set.size();
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private void dfs(int[][] grid, int x, int y, int i, int j, StringBuilder path) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;

        grid[i][j] = 2;
        path.append((i - x) * n + (j - y));
        for (int k = 0; k < 4; k++) {
            dfs(grid, x, y, i + dir[k], j + dir[k + 1], path);
        }
    }
}
