package _0113_Path_Sum_II;

import common.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            ans.add(new ArrayList<Integer>(path));
        }
        dfs(root.left, targetSum - root.val, path, ans);
        dfs(root.right, targetSum - root.val, path, ans);
        path.remove(path.size() - 1);
    }
}
