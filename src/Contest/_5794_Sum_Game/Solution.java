package Contest._5794_Sum_Game;

public class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0, leftQ = 0, rightQ = 0;
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }
        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }
        int k = leftQ - rightQ, sub = leftSum - rightSum;
        if (k == 0 && sub == 0) return false;
        if (k % 2 == 1) return true;
        return sub != -9 * k / 2;
    }
}
