package String._0151_Reverse_Words_in_a_String;

public class Solution {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int n = trim(c);

        reverse(c, 0, n - 1);
        int slow = 0, fast = 0;
        while (fast < n) {
            if (c[fast] == ' ') {
                reverse(c, slow, fast - 1);
                slow = fast + 1;
            }
            fast++;
        }
        reverse(c, slow, fast - 1);
        return String.valueOf(c, 0, n);
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

    public int trim(char[] c) {
        int slow = 0, fast = 0;
        while (fast < c.length) {
            if (c[fast] != ' ' || (fast > 0 && c[fast] == ' ' && c[fast - 1] != ' ')) {
                c[slow++] = c[fast];
            }
            fast++;
        }
        return (c[slow - 1] == ' ') ? slow - 1 : slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("  a good   example  "));
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
