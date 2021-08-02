package PrefixSum._1094_Car_Pooling;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] t : trips) {
            diff[t[1]] += t[0];
            diff[t[2]] -= t[0];
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) return false;
        }
        return true;
    }
}
