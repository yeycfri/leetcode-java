package Greedy._0968_Binary_Tree_Cameras;

import common.bst.TreeNode;

public class Solution {
    private static final int UNCOVERED = 0;
    private static final int HAS_CAMERA = 1;
    private static final int COVERED = 2;

    int result;

    public int minCameraCover(TreeNode root) {
        result = 0;
        if (traversal(root) == UNCOVERED) result++;
        return result;
    }

    private int traversal(TreeNode root) {
        if (root == null) return COVERED;

        int left = traversal(root.left);
        int right = traversal(root.right);

        if (left == UNCOVERED || right == UNCOVERED) {
            result++;
            return HAS_CAMERA;
        }

        return left == HAS_CAMERA || right == HAS_CAMERA ? COVERED : UNCOVERED;
    }
}
