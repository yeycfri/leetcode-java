package Graph._0310_Minimum_Height_Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<List<Integer>> next = new ArrayList<>();
        for (int i = 0; i < n; i++)
            next.add(new ArrayList<>());
        int[] degree = new int[n];
        for (int[] e : edges) {
            next.get(e[0]).add(e[1]);
            next.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            ans = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                ans.add(u);
                for (int v : next.get(u)) {
                    if (--degree[v] == 1) queue.offer(v);
                }
            }
        }
        return ans;
    }
}
