package Math._0497_Random_Point_in_Non_overlapping_Rectangles;

import java.util.Random;

public class Solution {
    int[][] rects;
    int[] w;
    Random r;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.r = new Random();
        this.w = new int[rects.length + 1];
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            w[i + 1] = w[i] + (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
        }
    }

    public int[] pick() {
        int target = r.nextInt(w[w.length - 1]);
        int i = search(w, target);
        int[] rect = rects[i - 1];
        int base = target - w[i - 1];
        int x = base % (rect[2] - rect[0] + 1) + rect[0];
        int y = base / (rect[2] - rect[0] + 1) + rect[1];
        return new int[]{x, y};
    }

    private int search(int[] w, int target) {
        int l = 1, r = w.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (target >= w[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
