package Greedy._0738_Monotone_Increasing_Digits;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] ch = Integer.toString(n).toCharArray();
        int pos = ch.length;
        for (int i = ch.length - 1; i > 0; i--) {
            if (ch[i] < ch[i - 1]) {
                pos = i;
                ch[i - 1]--;
            }
        }
        for (int i = pos; i < ch.length; i++) {
            ch[i] = '9';
        }
        return Integer.parseInt(new String(ch));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.monotoneIncreasingDigits(52321));
    }
}
