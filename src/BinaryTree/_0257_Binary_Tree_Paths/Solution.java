package BinaryTree._0257_Binary_Tree_Paths;

import common.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(root, path, ans);
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder path, List<String> ans) {
        if (root == null) return;
        int start = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(path.toString());
        }
        path.append("->");
        dfs(root.left, path, ans);
        dfs(root.right, path, ans);
        path.delete(start, path.length());
    }
}
