package PrefixSum._1854_Maximum_Population_Year;

public class Solution {
    private static final int MAX = 2050;
    private static final int MIN = 1950;

    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[MAX - MIN + 1];
        for (int[] log : logs) {
            diff[log[0] - MIN] += 1;
            diff[log[1] - MIN] -= 1;     // 与LCCI 16.10差别：死亡当年不计入生存人数
        }
        int maxyear = 0;
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > diff[maxyear]) maxyear = i;
        }
        return maxyear + MIN;
    }
}
