package Graph._0210_Course_Schedule_II;

import java.util.*;

public class Solution {
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] preq : prerequisites) {
            edges.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int cur = 0;
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans[cur++] = u;
            for (int v : edges.get(u)) {
                if (--indegree[v] == 0)
                    queue.offer(v);
            }
        }
        return cur == numCourses ? ans : new int[]{};
    }

    List<List<Integer>> edges;
    int[] state;
    int[] ans;
    int cur;

    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] preq : prerequisites) {
            edges.get(preq[1]).add(preq[0]);
        }
        state = new int[numCourses];
        ans = new int[numCourses];
        cur = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasLoop(i))
                break;
        }
        return cur == -1 ? ans : new int[]{};
    }

    private boolean hasLoop(int u) {
        state[u] = 1;
        for (int v : edges.get(u)) {
            if (state[v] == 1)
                return true;
            if (state[v] == 0 && hasLoop(v))
                return true;
        }
        ans[cur--] = u;
        state[u] = 2;
        return false;
    }
}
