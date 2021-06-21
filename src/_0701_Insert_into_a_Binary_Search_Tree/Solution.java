package _0701_Insert_into_a_Binary_Search_Tree;

import common.bst.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        while (node != null) {
            TreeNode prev = node;
            if (node.val > val) {
                node = node.left;
                if (node == null) prev.left = new TreeNode(val);
            } else {
                node = node.right;
                if (node == null) prev.right = new TreeNode(val);
            }
        }
        return root;
    }

    // 递归
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
