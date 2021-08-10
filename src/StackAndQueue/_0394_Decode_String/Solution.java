package StackAndQueue._0394_Decode_String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String decodeString(String s) {
        int ptr = 0, n = s.length();
        Deque<String> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        while (ptr < n) {
            if (Character.isDigit(s.charAt(ptr))) {
                int num = 0;
                while (Character.isDigit(s.charAt(ptr))) {
                    num = num * 10 + s.charAt(ptr++) - '0';
                }
                deque2.offerLast(num);
            } else if (Character.isLetter(s.charAt(ptr)) || s.charAt(ptr) == '[') {
                deque1.offerLast(String.valueOf(s.charAt(ptr++)));
            } else {
                List<String> list = new LinkedList<>();
                while (!deque1.peekLast().equals("[")) {
                    list.add(0, deque1.pollLast());
                }
                deque1.pollLast();

                StringBuilder sb = new StringBuilder();
                int num = deque2.pollLast();
                for (int i = 0; i < num; i++) {
                    for (String str : list) {
                        sb.append(str);
                    }
                }

                deque1.offerLast(sb.toString());
                ptr++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque1.isEmpty()) {
            sb.append(deque1.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("abc3[cd]xyz"));
    }
}
