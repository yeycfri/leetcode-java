package Backtracking._0046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] set;

    public List<List<Integer>> permute(int[] nums) {
        set = new int[nums.length];
        backtracking(nums);
        return ans;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set[i] == 1) continue;
            path.add(nums[i]);
            set[i] = 1;
            backtracking(nums);
            path.remove(path.size() - 1);
            set[i] = 0;
        }
    }
}
