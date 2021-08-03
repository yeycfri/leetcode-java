package Math._0069_Sqrt_x;

public class Solution {
    public int mySqrt(int x) {
        long sqrt = x;
        while (sqrt * sqrt > x) {
            sqrt = (sqrt + x / sqrt) >> 1;
        }
        return (int) sqrt;
    }
}
