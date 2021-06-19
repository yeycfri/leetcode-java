package _0222_Count_Complete_Tree_Nodes;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 层序遍历
    public int countNodesBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            root = queue.poll();
            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
        }
        return count;
    }

    // 递归遍历
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }

    // 利用完全二叉树特性递归计算
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) return (1 << leftDepth) + countNodes2(root.right);
        return (1 << rightDepth) + countNodes2(root.left);

    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    // 二分查找 + 位运算
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            level++;
        }
        int left = 1 << level, right = (2 << level) - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (exists(root, level, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        while (root != null && bits > 0) {
            if ((bits & k) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            bits >>= 1;
        }
        return root != null;
    }
}
