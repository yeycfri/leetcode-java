package _0202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0, tmp = n;
            while (tmp != 0) {
                int num = tmp % 10;
                sum += num * num;
                tmp /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (!set.add(sum)) return false;
            n = sum;
        }
    }
}
