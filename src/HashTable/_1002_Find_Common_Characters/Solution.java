package HashTable._1002_Find_Common_Characters;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] hash = new int[26];
        for (char ch : words[0].toCharArray()) {
            hash[ch - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] tmp = new int[26];
            for (char ch : words[i].toCharArray()) {
                tmp[ch - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                hash[j] = Math.min(hash[j], tmp[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < hash[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.commonChars(new String[]{"bella", "label", "roller"}));
    }
}
