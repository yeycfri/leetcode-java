package BinaryTree._0987_Vertical_Order_Traversal_of_a_Binary_Tree;

import common.bst.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> pos = new ArrayList<>();
        dfs(root, 0, 0, pos);
        pos.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[1] != p2[1])
                    return Integer.compare(p1[1], p2[1]);
                if (p1[0] != p2[0])
                    return Integer.compare(p1[0], p2[0]);
                return Integer.compare(p1[2], p2[2]);
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        int col = Integer.MIN_VALUE, idx = -1;
        for (int[] p : pos) {
            int r = p[0], c = p[1], v = p[2];
            if (col != c) {
                ans.add(new ArrayList<>());
                col = p[1];
                idx++;
            }
            ans.get(idx).add(v);
        }
        return ans;
    }

    private void dfs(TreeNode root, int r, int c, List<int[]> pos) {
        if (root == null) return;
        pos.add(new int[]{r, c, root.val});
        dfs(root.left, r + 1, c - 1, pos);
        dfs(root.right, r + 1, c + 1, pos);
    }
}
