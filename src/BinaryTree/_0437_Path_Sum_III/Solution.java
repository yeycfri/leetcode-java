package BinaryTree._0437_Path_Sum_III;

import common.bst.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return (root.val == targetSum ? 1 : 0) + dfs(root.left, targetSum - root.val) + dfs(root.right, targetSum - root.val);
    }

    public int pathSumPrefix(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, map, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Integer, Integer> map, int cursum, int targetSum) {
        if (root == null) return 0;
        cursum += root.val;

        int ans = 0;
        ans += map.getOrDefault(cursum - targetSum, 0);

        map.put(cursum, map.getOrDefault(cursum, 0) + 1);
        ans += dfs(root.left, map, cursum, targetSum);
        ans += dfs(root.right, map, cursum, targetSum);
        map.put(cursum, map.get(cursum) - 1);
        return ans;
    }
}
