package _0654_Maximum_Binary_Tree;

import common.bst.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (end <= start) return null;

        int i = getMax(nums, start, end);
        TreeNode root = new TreeNode(nums[i]);

        root.left = build(nums, start, i);
        root.right = build(nums, i + 1, end);
        return root;
    }

    private int getMax(int[] nums, int start, int end) {
        int idx = start, max = nums[start];
        for (int i = start; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
