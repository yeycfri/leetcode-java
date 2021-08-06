package BinaryTree._0114_Flatten_Binary_Tree_to_Linked_List;

import common.bst.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        if (root.left == null) return;
        TreeNode node = root.left;
        while (node.right != null) {
            node = node.right;
        }
        node.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
