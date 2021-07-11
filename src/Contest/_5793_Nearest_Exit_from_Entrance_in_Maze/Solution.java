package Contest._5793_Nearest_Exit_from_Entrance_in_Maze;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    int[] dir = new int[]{-1, 0, 1, 0, -1};

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '1';
        int steps = 0, m = maze.length, n = maze[0].length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int p = 0; p < size; p++) {
                int[] pos = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int i = pos[0] + dir[k], j = pos[1] + dir[k + 1];

                    if (i < 0 || i >= m || j < 0 || j >= n) continue;
                    if (maze[i][j] != '.') continue;

                    if (i == 0 || i == (m - 1) || j == 0 || j == (n - 1)) {
                        return steps;
                    }

                    maze[i][j] = '1';
                    queue.add(new int[]{i, j});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] maze = new char[][]{
                new char[]{'+', '.', '+', '+', '+', '+', '+'},
                new char[]{'+', '.', '+', '.', '.', '.', '+'},
                new char[]{'+', '.', '+', '.', '+', '.', '+'},
                new char[]{'+', '.', '.', '.', '.', '.', '+'},
                new char[]{'+', '+', '+', '+', '.', '+', '.'}
        };
        System.out.println(solution.nearestExit(maze, new int[]{0, 1}));
    }
}
