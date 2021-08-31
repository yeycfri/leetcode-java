package BinaryTree._0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import common.bst.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (istart > iend) return null;

        int rootVal = preorder[pstart];
        TreeNode root = new TreeNode(rootVal);

        int i = map.get(rootVal), leftLen = i - istart;
        root.left = build(preorder, pstart + 1, pstart + leftLen, inorder, istart, i - 1);
        root.right = build(preorder, pstart + leftLen + 1, pend, inorder, i + 1, iend);
        return root;
    }
}
