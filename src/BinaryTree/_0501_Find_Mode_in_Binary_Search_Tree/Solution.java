package BinaryTree._0501_Find_Mode_in_Binary_Search_Tree;

import common.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    List<Integer> ans = new ArrayList<>();
    int count, maxCount;
    TreeNode prev = null;

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        update(root);
        traversal(root.right);
    }

    private void update(TreeNode root) {
        if (prev == null) {
            count = 1;
        } else if (prev.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        prev = root;
        if (count == maxCount) {
            ans.add(root.val);
        }
        if (count > maxCount) {
            ans.clear();
            maxCount = count;
            ans.add(root.val);
        }
    }
}
