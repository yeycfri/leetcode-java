package Graph._0207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> nexts = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nexts.add(new ArrayList<>());
        }
        for (int[] preq : prerequisites) {
            nexts.get(preq[1]).add(preq[0]);
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasLoop(i, nexts, state))
                return false;
        }
        return true;
    }

    private boolean hasLoop(int u, List<List<Integer>> nexts, int[] state) {
        state[u] = 1;
        for (int v : nexts.get(u)) {
            if (state[v] == 1)
                return true;
            if (state[v] == 0 && hasLoop(v, nexts, state))
                return true;
        }
        state[u] = 2;
        return false;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
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

        while (!queue.isEmpty()) {
            numCourses--;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                if (--indegree[v] == 0)
                    queue.offer(v);
            }
        }
        return numCourses == 0;
    }
}
