package Greedy._0860_Lemonade_Change;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cash5 = 0;
        int cash10 = 0;
        for (int b : bills) {
            if (b == 5) {
                cash5++;
            } else if (b == 10) {
                if (cash5 > 0) {
                    cash10++;
                    cash5--;
                } else {
                    return false;
                }
            } else if (b == 20) {
                if (cash10 > 0 && cash5 > 0) {
                    cash10--;
                    cash5--;
                } else if (cash5 > 2) {
                    cash5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
