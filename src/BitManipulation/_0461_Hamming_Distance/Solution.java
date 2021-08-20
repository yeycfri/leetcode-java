package BitManipulation._0461_Hamming_Distance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int a = x ^ y, ans = 0;
        while (a != 0) {
            ans += a & 1;
            a >>= 1;
        }
        return ans;
    }
}
