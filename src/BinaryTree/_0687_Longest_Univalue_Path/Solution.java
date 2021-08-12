package BinaryTree._0687_Longest_Univalue_Path;

import common.bst.TreeNode;

public class Solution {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftLen = 0, rightLen = 0;
        if (root.left != null && root.left.val == root.val)
            leftLen += left + 1;
        if (root.right != null && root.right.val == root.val)
            rightLen += right + 1;

        ans = Math.max(ans, leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }
}
