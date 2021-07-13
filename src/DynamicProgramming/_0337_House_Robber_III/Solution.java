package DynamicProgramming._0337_House_Robber_III;

import common.bst.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int robDFS(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (map.containsKey(root)) return map.get(root);

        int val1 = root.val;
        if (root.left != null) val1 += robDFS(root.left.left) + robDFS(root.left.right);
        if (root.right != null) val1 += robDFS(root.right.left) + robDFS(root.right.right);

        int val2 = robDFS(root.left) + robDFS(root.right);
        int val = Math.max(val1, val2);
        map.put(root, val);
        return val;
    }

    public int rob(TreeNode root) {
        int[] dp = robTree(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] robTree(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = robTree(root.left), right = robTree(root.right);
        int val1 = root.val + left[0] + right[0];
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{val2, val1};
    }
}
