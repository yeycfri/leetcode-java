package _0040_Combination_Sum_II;

import java.util.*;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, target);
        return ans;
    }

    private void backtracking(int[] candidates, int start, int target) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && (sum + candidates[i] <= target); i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, i + 1, target);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
