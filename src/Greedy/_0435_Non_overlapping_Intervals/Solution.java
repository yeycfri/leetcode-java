package Greedy._0435_Non_overlapping_Intervals;

import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int ans = 1;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            } else {
                right = Math.min(right, intervals[i][1]);
            }
        }
        return intervals.length - ans;
    }
}
