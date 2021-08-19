# 二叉树

# 遍历

## 前序遍历

[144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

### 递归

``` java
public void traversal(TreeNode root) {
    if (root == null) return;
    doSomething(root);
    traversal(ans, root.left);
    traversal(ans, root.right);
}
```

## 后序遍历

[145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

### 递归

``` java
public void traversal(TreeNode root) {
    if (root == null) return;
    traversal(ans, root.left);
    traversal(ans, root.right);
    doSomething(root);
}
```

## 中序遍历

[94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

### 递归

``` java
public void traversal(TreeNode root) {
    if (root == null) return;
    traversal(ans, root.left);
    doSomething(root);
    traversal(ans, root.right);
}
```

### 迭代

``` java
public void inorder(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
        // 先推进到最左叶子，中间节点存放在栈中
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            doSomething(root);
            root = root.right;
        }
    }
}
```

## 层序遍历

[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

``` java
public void levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) queue.offer(root);
    while (!queue.isEmpty()) {
        // 这一层共有 size 个节点，若不需利用层的特性，可省去 for 循环
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            root = queue.poll();
            doSomething(root);
            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
        }
    }
}
```

# 题目

|题目|难度||
|---|---|---|
|[112. 路径总和](https://leetcode-cn.com/problems/path-sum/)|简单|√|
|[113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)|中等|√|
|[437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)|中等|√|
|[666. 路径总和 IV](https://leetcode-cn.com/problems/path-sum-iv/)|中等|√|
|[687. 最长同值路径](https://leetcode-cn.com/problems/longest-univalue-path/)|中等|√|
|[124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)|困难|√|
