package BinaryTree._0101_Symmetric_Tree;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && check(left.left, right.right) && check(left.right, right.left);
    }

    public boolean isSymmetricQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left != null) queue.offer(root.left);
        if (root.right != null) queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
