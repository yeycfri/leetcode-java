package BinaryTree._0543_Diameter_of_Binary_Tree;

import common.bst.TreeNode;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    int ans;

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftMaxDepth = dfs(root.left);
        int rightMaxDepth = dfs(root.right);
        ans = Math.max(ans, leftMaxDepth + rightMaxDepth);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
