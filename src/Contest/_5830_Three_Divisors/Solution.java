package Contest._5830_Three_Divisors;

public class Solution {
    public boolean isThree(int n) {
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if (i * i < n) cnt++;
            }
        }
        return cnt == 3;
    }
}
