package LCOF_05_Ti_Huan_Kong_Ge;

public class Solution {
    public String replaceSpace(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') count++;
        }
        int n = s.length();
        char[] c = new char[n + count * 2];
        int i = n - 1, j = c.length - 1;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                c[j--] = s.charAt(i--);
            } else {
                c[j--] = '0';
                c[j--] = '2';
                c[j--] = '%';
                i--;
            }
        }
        return String.valueOf(c);
    }
}
