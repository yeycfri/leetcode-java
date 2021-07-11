package BinaryTree._0515_Find_Largest_Value_in_Each_Tree_Row;

import common.bst.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                max = Math.max(root.val, max);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            ans.add(max);
        }
        return ans;
    }

    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) return;
        if (depth == ans.size()) {
            ans.add(root.val);
        } else {
            ans.set(depth, Math.max(root.val, ans.get(depth)));
        }
        depth++;
        dfs(root.left, depth, ans);
        dfs(root.right, depth, ans);
    }
}
