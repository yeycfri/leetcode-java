package Backtracking._0039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> ans;
    List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(candidates, 0, target);
        return ans;
    }

    private void dfs(int[] cand, int idx, int target) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < cand.length; i++) {
            path.add(cand[i]);
            dfs(cand, i, target - cand[i]);
            path.remove(path.size() - 1);
        }
    }
}
