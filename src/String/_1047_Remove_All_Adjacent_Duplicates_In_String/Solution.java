package String._1047_Remove_All_Adjacent_Duplicates_In_String;

public class Solution {

    public String removeDuplicates(String s) {
        char[] ans = new char[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < 1) {
                ans[i++] = c;
            } else {
                if (ans[i - 1] == c) {
                    i--;
                } else {
                    ans[i++] = c;
                }
            }
        }
        return String.valueOf(ans, 0, i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
}
