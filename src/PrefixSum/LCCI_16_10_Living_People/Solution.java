package PrefixSum.LCCI_16_10_Living_People;

public class Solution {
    private static final int MAX = 2000;
    private static final int MIN = 1900;

    public int maxAliveYear(int[] birth, int[] death) {
        int[] diff = new int[MAX - MIN + 2];
        for (int i = 0; i < birth.length; i++) {
            diff[birth[i] - MIN] += 1;
            diff[death[i] - MIN + 1] -= 1;     // 与1854题差别：死亡当年计入生存人数
        }
        int maxyear = 0;
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > diff[maxyear]) maxyear = i;
        }
        return maxyear + MIN;
    }
}
