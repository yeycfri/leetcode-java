# 并查集

``` java
public class UnionFind {
    private int count;
    private final int[] parent;
    private final int[] size;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // 根据树的大小合并，减小树高
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public int find(int x) {
        while (x != parent[x]) {
            // 路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}

```

## 题目

|题目|难度||
|---|---|---|
|[130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)|中等|√|
|[990. 等式方程的可满足性](https://leetcode-cn.com/problems/satisfiability-of-equality-equations/)|中等|√|
|[200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)|中等|√|
|[305. 岛屿数量 II](https://leetcode-cn.com/problems/number-of-islands-ii/)|困难|√|
|[827. 最大人工岛](https://leetcode-cn.com/problems/making-a-large-island/)|困难|√|
|[323. 无向图中连通分量的数目](https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph/)|中等|√|
