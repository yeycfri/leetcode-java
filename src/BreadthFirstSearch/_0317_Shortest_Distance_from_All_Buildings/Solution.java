package BreadthFirstSearch._0317_Shortest_Distance_from_All_Buildings;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[m][n];
        int cnt = 0, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = bfs(grid, dist, i, j, cnt--);
                    if (ans == -1) return -1;
                }
            }
        }
        return ans;
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private int bfs(int[][] grid, int[][] dist, int r, int c, int cnt) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        int steps = 0, min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                int x = p[0], y = p[1];
                for (int k = 0; k < 4; k++) {
                    int x1 = x + dir[k], y1 = y + dir[k + 1];
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == cnt) {
                        grid[x1][y1]--;
                        dist[x1][y1] += steps;
                        min = Math.min(min, dist[x1][y1]);
                        queue.offer(new int[]{x1, y1});
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid1 = new int[][]{
                new int[]{1, 0, 2, 0, 1},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0},
        };
        int[][] grid2 = new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1},
                new int[]{1, 1, 1, 1, 1, 1, 0, 1},
                new int[]{1, 0, 0, 0, 1, 1, 0, 1},
                new int[]{1, 0, 1, 1, 1, 1, 0, 1},
                new int[]{1, 0, 1, 0, 0, 1, 0, 1},
                new int[]{1, 0, 1, 1, 1, 1, 0, 1},
                new int[]{1, 0, 0, 0, 0, 0, 0, 1},
                new int[]{0, 1, 1, 1, 1, 1, 1, 0},
        };
        System.out.println(solution.shortestDistance(grid1));
        System.out.println(solution.shortestDistance(grid2));
    }
}
