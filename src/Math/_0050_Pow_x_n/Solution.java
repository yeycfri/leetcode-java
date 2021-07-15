package Math._0050_Pow_x_n;

public class Solution {
    public double myPow(double x, int n) {
        return ((long) n < 0) ? 1 / quick(x, -(long) n) : quick(x, n);
    }

    private double quick(double x, long n) {
        double ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
