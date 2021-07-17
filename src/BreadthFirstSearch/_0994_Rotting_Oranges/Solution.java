package BreadthFirstSearch._0994_Rotting_Oranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int goodCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) goodCount++;
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        int steps = 0;
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        while (goodCount > 0 && !queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                int x = p[0], y = p[1];
                for (int k = 0; k < 4; k++) {
                    int x1 = x + dir[k], y1 = y + dir[k + 1];
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == 1) {
                        grid[x1][y1] = 2;
                        goodCount--;
                        queue.offer(new int[]{x1, y1});
                    }
                }
            }
        }
        return goodCount != 0 ? -1 : steps;
    }
}
