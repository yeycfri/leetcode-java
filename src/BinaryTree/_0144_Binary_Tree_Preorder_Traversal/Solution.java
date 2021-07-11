package BinaryTree._0144_Binary_Tree_Preorder_Traversal;

import common.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        traversal(ans, root);
        return ans;
    }

    public void traversal(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        traversal(ans, root.left);
        traversal(ans, root.right);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return ans;
    }

    // 迭代法统一模板，插入null标记
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root != null) {
                stack.pop();
                if (root.right != null) stack.push(root.right);
                if (root.left != null) stack.push(root.left);
                stack.push(root);
                stack.push(null);
            } else {
                stack.pop();
                ans.add(stack.pop().val);
            }
        }
        return ans;
    }
}
