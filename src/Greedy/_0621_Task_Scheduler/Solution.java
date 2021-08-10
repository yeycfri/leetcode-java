package Greedy._0621_Task_Scheduler;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int total = tasks.length, maxExec = 0, maxCount = 0;
        int[] hash = new int[26];
        for (char c : tasks) {
            hash[c - 'A']++;
            if (hash[c - 'A'] > maxExec) {
                maxExec = hash[c - 'A'];
                maxCount = 1;
            } else if (hash[c - 'A'] == maxExec) {
                maxCount++;
            }
        }
        return Math.max(total, (maxExec - 1) * (n + 1) + maxCount);
    }
}
