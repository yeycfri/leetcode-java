package Backtracking._0077_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return ans;
    }

    void backtracking(int low, int high, int k) {
        if (arr.size() == k) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        for (int i = low; i <= (high - (k - arr.size())); i++) {
            arr.add(i);
            backtracking(i + 1, high, k);
            arr.remove(arr.size() - 1);
        }
    }
}
