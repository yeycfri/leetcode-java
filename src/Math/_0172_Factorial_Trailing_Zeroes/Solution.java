package Math._0172_Factorial_Trailing_Zeroes;

public class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        for (; n / 5 > 0; n /= 5)
            cnt += n / 5;
        return cnt;
    }
}
