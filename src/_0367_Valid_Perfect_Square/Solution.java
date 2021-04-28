package _0367_Valid_Perfect_Square;

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2;
        while (left <= right) {
            long mid = (left + right) / 2;
            long square = mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquareNewton(int num) {
        if (num < 2) return true;
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPerfectSquare(16));
        System.out.println(s.isPerfectSquare(14));
        System.out.println(s.isPerfectSquare(1));
        System.out.println(s.isPerfectSquare(4));
        System.out.println(s.isPerfectSquare(3));
        System.out.println(s.isPerfectSquare(Integer.MAX_VALUE));
    }
}
