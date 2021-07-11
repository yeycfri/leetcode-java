package BinaryTree._0094_Binary_Tree_Inorder_Traversal;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        traversal(ans, root);
        return ans;
    }

    public void traversal(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        traversal(ans, root.left);
        ans.add(root.val);
        traversal(ans, root.right);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }

    // 迭代法统一模板，插入null标记
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root != null) {
                stack.pop();
                if (root.right != null) stack.push(root.right);
                stack.push(root);
                stack.push(null);
                if (root.left != null) stack.push(root.left);
            } else {
                stack.pop();
                ans.add(stack.pop().val);
            }
        }
        return ans;
    }
}
