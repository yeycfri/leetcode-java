package _0069_Sqrt_x;

public class Solution {
    // 牛顿迭代法
    public int mySqrt1(int x) {
        if (x == 0) return 0;
        double sqrt = (double) x / 2, ans = (double) x;
        while (true) {
            sqrt = (sqrt + x / sqrt) / 2;
            if (Math.abs(ans - sqrt) < 1e-7) break;
            ans = sqrt;
        }
        return (int) ans;
    }

    // 二分查找
    public int mySqrt2(int x) {
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
        System.out.println(solution.mySqrt1(4));
        System.out.println(solution.mySqrt1(8));
        System.out.println(solution.mySqrt1(0));
        System.out.println(solution.mySqrt1(1));
        System.out.println(solution.mySqrt1(2));
        System.out.println(solution.mySqrt1(2147395599));
    }
}
