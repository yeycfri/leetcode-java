package _0094_Binary_Tree_Inorder_Traversal;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        traversal(ans, root);
        return ans;
    }

    public void traversal(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        traversal(ans, root.left);
        ans.add(root.val);
        traversal(ans, root.right);
    }
}
