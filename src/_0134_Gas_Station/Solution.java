package _0134_Gas_Station;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int minIdx = 0;
        int minRemain = Integer.MAX_VALUE;
        int remain = 0;
        for (int i = 0; i < n; i++) {
            remain += gas[i] - cost[i];
            if (remain < minRemain) {
                minRemain = remain;
                minIdx = i;
            }
        }
        return (remain < 0) ? -1 : (minIdx + 1) % n;
    }
}
