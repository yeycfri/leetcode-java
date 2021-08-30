package BinarySearch._0875_Koko_Eating_Bananas;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int l = 1, r = max;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (time(piles, m) > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int time(int[] piles, int k) {
        int cnt = 0;
        for (int pile : piles) {
            cnt += (pile + k - 1) / k;
        }
        return cnt;
    }
}
