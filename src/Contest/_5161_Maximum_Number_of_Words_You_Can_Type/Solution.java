package Contest._5161_Maximum_Number_of_Words_You_Can_Type;

public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }
        String[] strs = text.split(" ");
        int cnt = 0;
        for (String str : strs) {
            boolean flag = true;
            for (char c : str.toCharArray()) {
                if (broken[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}
