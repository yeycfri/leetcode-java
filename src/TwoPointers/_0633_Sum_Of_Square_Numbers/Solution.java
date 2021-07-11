package TwoPointers._0633_Sum_Of_Square_Numbers;

public class Solution {
    public boolean judgeSquareSumSqrt(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSumTwoPointer(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

    public boolean judgeSquareSumMath(int c) {
        for (int base = 2; base * base <= c; base++) {
            if (c % base != 0) continue;

            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }
            if (base % 4 == 3 && exp % 2 != 0) return false;
        }
        return c % 4 != 3;
    }
}
