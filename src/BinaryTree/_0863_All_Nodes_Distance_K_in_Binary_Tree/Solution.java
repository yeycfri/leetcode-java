package BinaryTree._0863_All_Nodes_Distance_K_in_Binary_Tree;

import common.bst.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> parents = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        findParents(parents, root);
        findK(ans, parents, target, null, 0, k);
        return ans;
    }

    private void findParents(Map<Integer, TreeNode> parents, TreeNode root) {
        if (root.left != null) {
            parents.put(root.left.val, root);
            findParents(parents, root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            findParents(parents, root.right);
        }
    }

    private void findK(List<Integer> ans, Map<Integer, TreeNode> parents, TreeNode cur, TreeNode from, int dist, int k) {
        if (cur == null)
            return;
        if (dist == k) {
            ans.add(cur.val);
            return;
        }
        if (cur.left != from) {
            findK(ans, parents, cur.left, cur, dist + 1, k);
        }
        if (cur.right != from) {
            findK(ans, parents, cur.right, cur, dist + 1, k);
        }
        TreeNode parent = parents.get(cur.val);
        if (parent != from) {
            findK(ans, parents, parent, cur, dist + 1, k);
        }
    }
}
