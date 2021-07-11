package Backtracking._0216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return ans;
    }

    private void backtracking(int k, int n, int low) {
        if (sum > n) return;
        if (arr.size() == k) {
            if (sum == n) ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = low; i <= (9 - (k - arr.size()) + 1); i++) {
            arr.add(i);
            sum += i;
            backtracking(k, n, i + 1);
            arr.remove(arr.size() - 1);
            sum -= i;
        }
    }
}
