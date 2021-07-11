package BinaryTree._0297_Serialize_and_Deserialize_Binary_Tree;

import common.bst.TreeNode;

import java.util.Arrays;
import java.util.Iterator;

public class Codec {

    private static final String NONE = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seDFS(root, sb);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    private void seDFS(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(',').append(NONE);
            return;
        }
        sb.append(',').append(root.val);
        seDFS(root.left, sb);
        seDFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Iterator<String> it = Arrays.asList(data.split(",")).iterator();
        return deDFS(it);
    }

    private TreeNode deDFS(Iterator<String> it) {
        if (!it.hasNext()) {
            return null;
        }
        String val = it.next();
        if (val.equals(NONE)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deDFS(it);
        root.right = deDFS(it);
        return root;
    }
}
