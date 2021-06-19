package _0513_Find_Bottom_Left_Tree_Value;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int findBottomLeftValueBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (i == 0) ans = root.val;
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
        }
        return ans;
    }

    int curDepth = -1, curValue = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return curValue;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > curDepth) {
            curDepth = depth;
            curValue = root.val;
        }
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
        return;
    }
}
