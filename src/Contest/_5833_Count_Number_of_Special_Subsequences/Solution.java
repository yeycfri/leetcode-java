package Contest._5833_Count_Number_of_Special_Subsequences;

public class Solution {
    public int countSpecialSubsequences(int[] nums) {
        int f0 = 0, f1 = 0, f2 = 0, mod = (int) 1e9 + 7;
        for (int num : nums) {
            if (num == 0)
                f0 = (f0 * 2 + 1) % mod;
            else if (num == 1)
                f1 = (f1 * 2 % mod + f0) % mod;
            else if (num == 2)
                f2 = (f2 * 2 % mod + f1) % mod;
        }
        return f2;
    }
}
