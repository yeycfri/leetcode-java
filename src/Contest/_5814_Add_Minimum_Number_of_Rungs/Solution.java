package Contest._5814_Add_Minimum_Number_of_Rungs;

public class Solution {
    public int addRungs(int[] rungs, int dist) {
        int n = rungs.length, cur = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cur + dist < rungs[i]) {
                cnt += (rungs[i] - cur - 1) / dist;
            }
            cur = rungs[i];
        }
        return cnt;
    }
}
