package _0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import common.bst.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int istart, int iend) {
        if (iend <= istart) return null;

        int rootVal = preorder[pstart];
        TreeNode root = new TreeNode(rootVal);
        int i = map.get(rootVal);

        root.left = build(preorder, pstart + 1, pstart + 1 + i - istart, istart, i);
        root.right = build(preorder, pstart + 1 + i - istart, pend, i + 1, iend);
        return root;
    }
}
