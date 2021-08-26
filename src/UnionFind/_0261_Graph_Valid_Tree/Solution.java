package UnionFind._0261_Graph_Valid_Tree;

public class Solution {
    class UF {
        int[] parent;
        int count;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return;
            parent[rp] = rq;
            count--;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (uf.connected(e[0], e[1]))
                return false;
            uf.union(e[0], e[1]);
        }
        return uf.count == 1;
    }
}
