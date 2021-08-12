package Greedy._0252_Meeting_Rooms;

import java.util.Arrays;

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int n = intervals.length, cur = 0;
        for (int[] itv : intervals) {
            if (itv[0] < cur)
                return false;
            else
                cur = itv[1];
        }
        return true;
    }
}
