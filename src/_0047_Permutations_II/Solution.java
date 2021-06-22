package _0047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] set;

    public List<List<Integer>> permuteUnique(int[] nums) {
        set = new int[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return ans;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && set[i - 1] == 0) continue;
            if (set[i] == 0) {
                set[i] = 1;
                path.add(nums[i]);
                backtracking(nums);
                set[i] = 0;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 1, 1}));
    }
}
