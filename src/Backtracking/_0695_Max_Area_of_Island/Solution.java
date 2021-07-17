package Backtracking._0695_Max_Area_of_Island;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        int sum = 1;
        for (int k = 0; k < 4; k++) {
            sum += dfs(grid, i + dir[k], j + dir[k + 1]);
        }
        return sum;
    }
}
