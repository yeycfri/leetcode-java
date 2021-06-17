package _0145_Binary_Tree_Postorder_Traversal;

import common.bst.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        traversal(ans, root);
        return ans;
    }

    public void traversal(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        traversal(ans, root.left);
        traversal(ans, root.right);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        Collections.reverse(ans);
        return ans;
    }

    // 迭代法统一模板，插入null标记
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root != null) {
                stack.pop();
                stack.push(root);
                stack.push(null);
                if (root.right != null) stack.push(root.right);
                if (root.left != null) stack.push(root.left);
            } else {
                stack.pop();
                ans.add(stack.pop().val);
            }
        }
        return ans;
    }
}
