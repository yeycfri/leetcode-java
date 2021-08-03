package Math._0204_Count_Primes;

public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i * i <= n; i++) {
            if (notPrime[i]) {
                for (int j = i * i; j < n; j += i)
                    notPrime[j] = true;
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++)
            if (!notPrime[i]) cnt++;
        return cnt;
    }
}
