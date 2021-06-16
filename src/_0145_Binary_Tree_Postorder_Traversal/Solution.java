package _0145_Binary_Tree_Postorder_Traversal;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        traversal(ans, root);
        return ans;
    }

    public void traversal(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        traversal(ans, root.left);
        traversal(ans, root.right);
        ans.add(root.val);
    }
}
