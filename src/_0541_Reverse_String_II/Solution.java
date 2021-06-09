package _0541_Reverse_String_II;

public class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length, idx = 0;
        while (idx < n) {
            int left = idx, right = Math.min(idx + k - 1, n - 1);
            while (left < right) {
                c[left] ^= c[right];
                c[right] ^= c[left];
                c[left] ^= c[right];
                left++;
                right--;
            }
            idx += 2 * k;
        }
        return String.valueOf(c);
    }
}
