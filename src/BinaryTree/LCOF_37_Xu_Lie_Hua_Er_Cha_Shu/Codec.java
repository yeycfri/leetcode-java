package BinaryTree.LCOF_37_Xu_Lie_Hua_Er_Cha_Shu;

import common.bst.TreeNode;

import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seRecursive(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void seRecursive(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(',');
            return;
        }
        sb.append(root.val).append(',');
        seRecursive(root.left, sb);
        seRecursive(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Iterator<String> it = Arrays.asList(strs).iterator();
        return deRecursive(it);
    }

    private TreeNode deRecursive(Iterator<String> it) {
        if (!it.hasNext()) {
            return null;
        }
        String val = it.next();
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deRecursive(it);
        root.right = deRecursive(it);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
