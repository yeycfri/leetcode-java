package Backtracking._0039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, target);
        return ans;
    }

    private void backtracking(int[] candidates, int start, int target) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        for (int i = start; i < candidates.length && (sum + candidates[i] > target); i++) {
            arr.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, i, target);
            arr.remove(arr.size() - 1);
            sum -= candidates[i];
        }
    }
}
