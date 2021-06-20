package _0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import common.bst.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode build(int[] postorder, int istart, int iend, int pstart, int pend) {
        if (iend <= istart) return null;

        int rootVal = postorder[pend - 1];
        TreeNode root = new TreeNode(rootVal);
        int i = map.get(rootVal);

        root.left = build(postorder, istart, i, pstart, pstart + i - istart);
        root.right = build(postorder, i + 1, iend, pstart + i - istart, pend - 1);
        return root;
    }
}
