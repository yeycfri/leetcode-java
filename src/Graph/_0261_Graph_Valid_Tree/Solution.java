package Graph._0261_Graph_Valid_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) return false;

        Map<Integer, List<Integer>> next = new HashMap<>();
        for (int i = 0; i < n; i++)
            next.put(i, new ArrayList<>());
        for (int[] e : edges) {
            next.get(e[0]).add(e[1]);
            next.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(0, next, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int u, Map<Integer, List<Integer>> next, boolean[] visited) {
        visited[u] = true;
        for (int v : next.get(u)) {
            if (visited[v]) continue;
            dfs(v, next, visited);
        }
    }
}
