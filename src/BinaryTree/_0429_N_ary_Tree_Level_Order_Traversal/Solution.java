package BinaryTree._0429_N_ary_Tree_Level_Order_Traversal;

import java.util.*;

public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrderBFS(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                level.add(root.val);
                queue.addAll(root.children);
            }
            ans.add(level);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderRecursive(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        traversal(root, 0, ans);
        return ans;
    }

    private void traversal(Node root, int depth, List<List<Integer>> ans) {
        if (root == null) return;
        if (depth == ans.size()) ans.add(new ArrayList<>());
        ans.get(depth).add(root.val);
        for (Node node : root.children) {
            traversal(node, depth + 1, ans);
        }
    }
}
