package UnionFind._0305_Number_of_Islands_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    class UnionFind {
        int count;
        int[] parent;
        int size;

        public UnionFind(int n) {
            size = n;
            count = 0;
            parent = new int[n + 1];
            Arrays.fill(parent, n);
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
            parent[rP] = rQ;
            count--;
        }

        public void reset(int x) {
            if (parent[x] == size) {
                parent[x] = x;
                count++;
            }
        }

        public int count() {
            return count;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        int size = m * n;
        UnionFind uf = new UnionFind(size);
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        List<Integer> ans = new ArrayList<>();
        for (int[] p : positions) {
            int i = p[0], j = p[1];
            grid[i][j] = 1;
            uf.reset(i * n + j);
            for (int k = 0; k < 4; k++) {
                int x = i + dir[k], y = j + dir[k + 1];
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
                uf.union(i * n + j, x * n + y);
            }
            ans.add(uf.count());
        }
        return ans;
    }
}
