package Math._0793_Preimage_Size_of_Factorial_Zeroes_Function;

public class Solution {
    public int preimageSizeFZF(long k) {
        long l = k, r = 5L * k + 1;
        while (l < r) {
            long m = l + ((r - l) >> 1);
            long cnt = tailingZeros(m);
            if (cnt == k) {
                return 5;
            } else if (cnt > k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }

    private long tailingZeros(long n) {
        long cnt = 0;
        for (; n / 5 > 0; n /= 5)
            cnt += n / 5;
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.preimageSizeFZF(5));
    }
}
