package _0530_Minimum_Absolute_Difference_in_BST;

import common.bst.TreeNode;

import java.util.Stack;

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    int min = Integer.MAX_VALUE;
    TreeNode prev = null;

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        traversal(root.right);
    }

    // 迭代
    public int getMinimumDifference2(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (prev != null) min = Math.min(min, root.val - prev.val);
                prev = root;
                root = root.right;
            }
        }
        return min;
    }
}
