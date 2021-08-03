package BinarySearch._0069_Sqrt_x;

public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 2) return 1;
        int left = 0, right = x / 2;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(0));
        System.out.println(solution.mySqrt(1));
        System.out.println(solution.mySqrt(2));
        System.out.println(solution.mySqrt(2147395599));
    }
}
