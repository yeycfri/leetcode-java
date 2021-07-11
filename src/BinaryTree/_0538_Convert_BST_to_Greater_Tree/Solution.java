package BinaryTree._0538_Convert_BST_to_Greater_Tree;

import common.bst.TreeNode;

public class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }
}
