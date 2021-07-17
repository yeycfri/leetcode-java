package BreadthFirstSearch._0286_Walls_and_Gates;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final int EMPTY = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) queue.offer(new int[]{i, j});
            }
        }
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0], j = p[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dir[k], y = j + dir[k + 1];
                if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != EMPTY) continue;
                rooms[x][y] = rooms[i][j] + 1;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
