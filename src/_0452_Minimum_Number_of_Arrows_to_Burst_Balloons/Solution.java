package _0452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int ans = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                ans++;
                right = points[i][1];
            } else {
                right = Math.min(right, points[i][1]);
            }
        }
        return ans;
    }
}
