package BinaryTree._0938_Range_Sum_Of_BST;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > high) return rangeSumBST(root.left, low, high);
        if (root.val < low) return rangeSumBST(root.right, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public int rangeSumBSTBFS(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == null) {
                continue;
            }
            if (cur.val > high) {
                queue.add(cur.left);
            } else if (cur.val < low) {
                queue.add(cur.right);
            } else {
                sum += cur.val;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return sum;
    }
}