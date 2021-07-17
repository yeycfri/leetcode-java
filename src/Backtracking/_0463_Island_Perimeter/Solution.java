package Backtracking._0463_Island_Perimeter;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int size = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return dfs(grid, i, j);
            }
        }
        return 0;
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) return 0;
        grid[i][j] = 2;
        int len = 0;
        for (int k = 0; k < 4; k++) {
            len += dfs(grid, i + dir[k], j + dir[k + 1]);
        }
        return len;
    }
}
