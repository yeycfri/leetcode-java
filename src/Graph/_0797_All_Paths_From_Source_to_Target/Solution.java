package Graph._0797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, ans, path);
        return ans;
    }

    private void dfs(int[][] graph, int v, List<List<Integer>> ans, List<Integer> path) {
        int n = graph.length;
        if (v == n - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int nxt : graph[v]) {
            path.add(nxt);
            dfs(graph, nxt, ans, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = new int[][]{
                new int[]{1, 2},
                new int[]{3},
                new int[]{3},
                new int[]{}
        };
        System.out.println(solution.allPathsSourceTarget(graph));
    }
}
