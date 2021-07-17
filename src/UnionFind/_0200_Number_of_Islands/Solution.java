package UnionFind._0200_Number_of_Islands;

import common.UnionFind;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dummy = m * n;
        UnionFind uf = new UnionFind(dummy + 1);

        int[][] dir = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
        };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') uf.union(dummy, i * n + j);
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 2; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (x >= m || y >= n) continue;
                        if (grid[x][y] == '1') uf.union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return uf.count() - 1;
    }

    public int numIslandsDFS(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int size = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    size++;
                    dfs(grid, i, j);
                }
            }
        }
        return size;
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '-';
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dir[k], j + dir[k + 1]);
        }
    }

    public int numIslandsBFS(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int size = 0;
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;
                size++;
                queue.offer(new int[]{i, j});
                grid[i][j] = '-';
                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    int x = pos[0];
                    int y = pos[1];
                    for (int k = 0; k < 4; k++) {
                        int x1 = x + dir[k];
                        int y1 = y + dir[k + 1];
                        if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] != '1') continue;
                        queue.offer(new int[]{x1, y1});
                        grid[x1][y1] = '-';
                    }
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'},
        };
        System.out.println(solution.numIslands(grid));
    }
}
