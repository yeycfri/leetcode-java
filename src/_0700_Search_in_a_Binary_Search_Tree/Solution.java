package _0700_Search_in_a_Binary_Search_Tree;

import common.bst.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    // 迭代
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
}
