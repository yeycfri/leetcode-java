package _0144_Binary_Tree_Preorder_Traversal;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        traversal(ans, root);
        return ans;
    }

    public void traversal(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        traversal(ans, root.left);
        traversal(ans, root.right);
    }
}
