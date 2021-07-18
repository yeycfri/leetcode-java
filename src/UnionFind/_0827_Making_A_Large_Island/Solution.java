package UnionFind._0827_Making_A_Large_Island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    class UnionFind {
        int[] parent;
        int[] size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int p, int q) {
            int rP = find(p);
            int rQ = find(q);
            if (rP == rQ) return;
            if (rP < rQ) {
                parent[rQ] = rP;
                size[rP] += size[rQ];
            } else {
                parent[rP] = rQ;
                size[rQ] += size[rP];
            }
        }

        public int size(int x) {
            return size[x];
        }
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) dfs(grid, i, j, i, j, uf);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int sum = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k], y = j + dir[k + 1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 2) continue;
                        int root = uf.find(x * n + y);
                        if (set.add(root)) {
                            sum += uf.size(root);
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max == Integer.MIN_VALUE ? m * n : max;
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private void dfs(int[][] grid, int x, int y, int i, int j, UnionFind uf) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;

        grid[i][j] = 2;
        uf.union(x * n + y, i * n + j);
        for (int k = 0; k < 4; k++) {
            dfs(grid, x, y, i + dir[k], j + dir[k + 1], uf);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                new int[]{1, 1},
                new int[]{1, 0},
        };
        System.out.println(solution.largestIsland(grid));
    }
}
