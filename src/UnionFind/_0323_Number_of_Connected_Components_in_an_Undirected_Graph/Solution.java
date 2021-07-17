package UnionFind._0323_Number_of_Connected_Components_in_an_Undirected_Graph;

import common.UnionFind;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        return uf.count();
    }
}
