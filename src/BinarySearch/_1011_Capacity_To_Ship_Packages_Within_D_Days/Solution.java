package BinarySearch._1011_Capacity_To_Ship_Packages_Within_D_Days;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(new Solution().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(new Solution().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }
}
