package DynamicProgramming._0338_Counting_Bits;

public class Solution {
    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            ans[i] = ans[i - highBit] + 1;
        }
        return ans;
    }

    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public int[] countBits3(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}
