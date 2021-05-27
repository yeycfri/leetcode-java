package _0275_H_Index_II;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (citations[n - 1] == 0) return 0;

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (citations[mid] < (n - mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (n - left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[]{0, 0, 0}));
    }
}
