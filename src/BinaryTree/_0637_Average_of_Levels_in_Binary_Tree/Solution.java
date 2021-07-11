package BinaryTree._0637_Average_of_Levels_in_Binary_Tree;

import common.bst.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                sum += root.val;
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            ans.add(sum / size);
        }
        return ans;
    }

    public List<Double> averageOfLevelsDFS(TreeNode root) {
        List<Double> sums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        dfs(root, 0, sums, counts);
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < sums.size(); i++) {
            ans.add(sums.get(i) / counts.get(i));
        }
        return ans;
    }

    public void dfs(TreeNode root, int depth, List<Double> sums, List<Integer> counts) {
        if (root == null) return;
        if (depth == sums.size()) {
            sums.add((double) root.val);
            counts.add(1);
        } else {
            sums.set(depth, sums.get(depth) + root.val);
            counts.set(depth, counts.get(depth) + 1);
        }
        depth++;
        dfs(root.left, depth, sums, counts);
        dfs(root.right, depth, sums, counts);
    }
}
