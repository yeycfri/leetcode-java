package BitManipulation._0191_Number_of_1_Bits;

public class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }
}
