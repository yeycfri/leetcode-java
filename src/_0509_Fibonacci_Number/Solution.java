package _0509_Fibonacci_Number;

public class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        int f1 = 0, f2 = 1;
        while (n > 0) {
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
            n--;
        }
        return f1;
    }
}
