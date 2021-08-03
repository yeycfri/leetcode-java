package Math._0372_Super_Pow;

// (a * b) % k = (a % k) * (b % k) % k
// 证明：假设 a = Ak +B，b = Ck + D
// => ab = ACk^2 + ADk + BCk +BD
// => ab % k = BD % k
// 因为 a % k = B，b % k = D => 得证

public class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return superP(a, b, b.length - 1);
    }

    private int superP(int a, int[] b, int idx) {
        if (idx < 0) return 1;
        return pow(a, b[idx]) * pow(superP(a, b, idx - 1), 10) % MOD;
    }

    private int pow(int a, int k) {
        if (k == 0) return 1;
        a %= MOD;
        if ((k & 1) == 1) {
            return pow(a, k - 1) * a % MOD;
        } else {
            int half = pow(a, k / 2);
            return half * half % MOD;
        }
    }
}
