package BinaryTree._0270_Closest_Binary_Search_Tree_Value;

import common.bst.TreeNode;

public class Solution {
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        while (root != null) {
            ans = (Math.abs(ans - target) > Math.abs(root.val - target)) ? root.val : ans;
            root = root.val > target ? root.left : root.right;
        }
        return ans;
    }
}
