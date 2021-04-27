package _0066_Plus_One;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int up = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += up;
            up = digits[i] / 10;
            digits[i] %= 10;
        }
        if (up != 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = up;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.plusOne2(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(s.plusOne2(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(s.plusOne2(new int[]{0})));
        System.out.println(Arrays.toString(s.plusOne2(new int[]{9, 9})));
    }
}
