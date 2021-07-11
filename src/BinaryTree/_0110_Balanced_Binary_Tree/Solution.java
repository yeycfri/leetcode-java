package BinaryTree._0110_Balanced_Binary_Tree;

import common.bst.TreeNode;

public class Solution {
    public boolean isBalancedUpToBottom(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) && isBalancedUpToBottom(root.left) && isBalancedUpToBottom(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    public boolean isBalancedBottomToUp(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
