package BinaryTree._0199_Binary_Tree_Right_Side_View;

import common.bst.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            ans.add(root.val);
        }
        return ans;
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root, 0);
        return ans;
    }

    public void dfs(List<Integer> ans, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == ans.size()) ans.add(root.val);
        depth++;
        dfs(ans, root.right, depth);
        dfs(ans, root.left, depth);
    }
}
