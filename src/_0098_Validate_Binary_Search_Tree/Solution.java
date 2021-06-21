package _0098_Validate_Binary_Search_Tree;

import common.bst.TreeNode;

import java.util.Stack;

public class Solution {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    // 迭代
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (prev != null && root.val <= prev.val) return false;
                prev = root;
                root = root.right;
            }
        }
        return true;
    }
}
