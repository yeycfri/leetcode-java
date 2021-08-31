package BinaryTree._0129_Sum_Root_to_Leaf_Numbers;

import common.bst.TreeNode;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prev) {
        if (root == null) return 0;
        int sum = prev * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
