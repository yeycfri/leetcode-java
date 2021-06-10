package LCOF_58_II_Zuo_Xuan_Zhuan_Zi_Fu_Chuan;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] c = s.toCharArray();
        n %= s.length();
        reverse(c, 0, n - 1);
        reverse(c, n, s.length() - 1);
        reverse(c, 0, s.length() - 1);
        return String.valueOf(c);
    }

    public void reverse(char[] c, int left, int right) {
        while (left < right) {
            c[left] ^= c[right];
            c[right] ^= c[left];
            c[left] ^= c[right];
            right--;
            left++;
        }
    }
}
