package BinaryTree._0124_Binary_Tree_Maximum_Path_Sum;

import common.bst.TreeNode;

public class Solution {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return -1;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
